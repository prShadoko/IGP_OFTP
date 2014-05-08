package oftp.monitor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import oftp.automaton.event.monitor.AbstractSocketInitialisationArchetype;
import oftp.automaton.event.monitor.MonitorEvent;
import oftp.automaton.event.monitor.NetworkConnectionIndicationArchetype;
import automaton.event.Event;
import automaton.event.EventLayer;

public class MonitorAcceptor extends EventLayer implements Runnable {

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
			
			MonitorEvent nConInd = new MonitorEvent(new NetworkConnectionIndicationArchetype());
			nConInd.putAttribute(AbstractSocketInitialisationArchetype.SOCKET, socket);
			
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

	@Override
	public void inform(Event<?> publication) {
		// TODO Auto-generated method stub
		
	}
}