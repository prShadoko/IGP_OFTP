package automaton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import automaton.event.Event;
import automaton.event.EventLayer;
import automaton.state.State;

public abstract class AbstractAutomaton extends EventLayer implements Automaton {

	Thread mainThread;

	private State state;

	private Collection<Event<?>> outputEvents = new ArrayList<>();

	private Queue<Event<?>> queue = new ConcurrentLinkedQueue<Event<?>>();

	public AbstractAutomaton(State state) {
		setState(state);
	}

	protected abstract void setUp();

	protected abstract void tearDown();

	@Override
	public void run() {
		setUp();
		
		while (null != state) {
			state.run(this);
		}

		tearDown();
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public void addOutputEvent(Event<?> event) {
		outputEvents.add(event);
	}

	@Override
	public void sendOutputEvents() {
		for (Event<?> event : outputEvents) {
			System.out.println("Send event: " + event.toString());
			publish(event);
		}
		outputEvents.clear();
	}

	@Override
	public Event<?> receiveEvent() {
		mainThread = Thread.currentThread();

		Event<?> event = queue.poll();

		while (null == event) {
			try {
				final Thread currentThread = Thread.currentThread();

				Thread sleeper = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							synchronized (currentThread) {
								currentThread.wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

				sleeper.start();
				sleeper.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			event = queue.poll();
		}
		return event;
	}

	@Override
	public void inform(Event<?> event) {
		queue.add(event);
		if (null != mainThread) {
			synchronized (mainThread) {
				mainThread.notifyAll();
			}
		}
	}
}
