package automaton;

import automaton.event.Event;
import automaton.event.EventLayer;
import automaton.exception.AutomatonException;
import automaton.state.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class AbstractAutomaton extends EventLayer implements Automaton {

	Thread mainThread;

	private State state;

	private Collection<Event<?>> outputEvents = new ArrayList<>();

	private Queue<Event<?>> queue = new ConcurrentLinkedQueue<Event<?>>();

	public AbstractAutomaton() {
	}

	protected abstract void setUp() throws AutomatonException;

	protected abstract void tearDown();

	@Override
	public void run() {
		try {
			setUp();

			while(null != state) {
				state = state.run(this);
			}
		} catch(AutomatonException e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	@Override
	public void addOutputEvent(Event<?> event) {
		outputEvents.add(event);
	}

	@Override
	public void sendOutputEvents() {
		for(Event<?> event : outputEvents) {
			System.out.println("Send event: " + event.toString());
			publish(event);
		}
		outputEvents.clear();
	}

	@Override
	public Event<?> receiveEvent() {
		mainThread = Thread.currentThread();

		Event<?> event = queue.poll();

		while(null == event) {
			try {
				final Thread currentThread = Thread.currentThread();

				Thread sleeper = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							synchronized(currentThread) {
								currentThread.wait();
							}
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

				sleeper.start();
				sleeper.join();
			} catch(InterruptedException e) {
				System.out.println("Sleeper join error : " + e.getMessage());
			}
			event = queue.poll();
		}
		return event;
	}

	@Override
	public void inform(Event<?> event) {
		queue.add(event);
		if(null != mainThread) {
			synchronized(mainThread) {
				mainThread.notifyAll();
			}
		}
	}

	public void setState(State state) {
		this.state = state;
	}
}
