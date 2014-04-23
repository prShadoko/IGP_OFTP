package automaton;

import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import automaton.event.Event;
import automaton.state.State;

public abstract class AbstractAutomaton implements Automaton, Observer {

	Thread mainThread;

	private State state;

	private Queue<Event> queue = new ConcurrentLinkedQueue<Event>();

	public AbstractAutomaton(State state) {
		setState(state);

		mainThread = Thread.currentThread();
	}

	@Override
	public void run() {
		while (null != state) {
			state.run(this);
		}
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public Event receiveEvent() {
		Event event = queue.poll();

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
	public void update(Observable o, Object arg) {
		if (null != arg && arg instanceof Event) {
			queue.add((Event) arg);
			synchronized (mainThread) {
				mainThread.notifyAll();
			}
		}
	}
}
