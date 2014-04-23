package oftp.monitor;

import java.util.Observable;

import oftp.automaton.event.MonitorEvent;

public class Monitor extends Observable implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			setChanged();
			notifyObservers(new MonitorEvent("F_CONNECT_RQ"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}