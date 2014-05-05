package oftp.monitor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import oftp.automaton.event.monitor.MonitorEvent;
import oftp.automaton.event.monitor.NetworkConnectionIndicationEvent;
import pattern.publish.subscribe.Publisher;
import automaton.event.Event;

public class MonitorAcceptor extends Publisher<Event> implements Runnable {

	public static final int LISTEN_PORT = 10101;
	
	@Override
	public void run() {
		try {
			OFTPAutomaton oftp = OFTPAutomaton.build();
			this.subscribe(MonitorEvent.class, oftp);
			
			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			System.out.println("Wait for connection");
			ServerSocket server = new ServerSocket(LISTEN_PORT);
			Socket socket = server.accept();
			server.close();
			
			NetworkConnectionIndicationEvent nConInd = new NetworkConnectionIndicationEvent();
			nConInd.setSocket(socket);
			
			publish(nConInd);
			
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
		MonitorAcceptor monitor = new MonitorAcceptor();
		monitor.run();
	}
}