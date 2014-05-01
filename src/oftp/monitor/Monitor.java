package oftp.monitor;

import oftp.automaton.event.monitor.MonitorEvent;
import pattern.publish.subscribe.Publisher;
import automaton.event.Event;

public class Monitor extends Publisher<Event> implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			publish(new MonitorEvent("F_CONNECT_RQ"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}