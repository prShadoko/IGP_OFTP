package oftp.monitor;

import java.io.IOException;
import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import oftp.automaton.event.monitor.FConnectRequestEvent;
import oftp.automaton.event.monitor.MonitorEvent;
import pattern.publish.subscribe.Publisher;
import automaton.event.Event;

public class MonitorInitiator extends Publisher<Event> implements Runnable {
	@Override
	public void run() {
		try {
			
			OFTPAutomaton oftp = OFTPAutomaton.build();
			this.subscribe(MonitorEvent.class, oftp);
			
			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			Socket socket = new Socket("localhost", MonitorAcceptor.LISTEN_PORT);
			FConnectRequestEvent fConReq = new FConnectRequestEvent();
			fConReq.setSocket(socket);
			
			publish(fConReq);
			
			oftpThread.join();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MonitorInitiator monitor = new MonitorInitiator();
		monitor.run();
	}
}