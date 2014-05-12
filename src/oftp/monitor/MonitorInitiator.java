package oftp.monitor;

import java.io.IOException;
import java.net.Socket;

import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import automaton.event.Event;
import automaton.event.EventLayer;

public class MonitorInitiator extends EventLayer implements Runnable {
	@Override
	public void run() {
		try {
			
			OftpAutomaton oftp = OftpAutomaton.build(false, CapabilityInit.BOTH, CapabilityMode.BOTH, 999999, 999);
			this.subscribe(MonitorEvent.class, oftp);
			
			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			Socket socket = new Socket("192.168.0.11", MonitorAcceptor.LISTEN_PORT);
			MonitorEvent fConReq = new MonitorEvent(new FConnectionRequestArchetype());
			fConReq.putAttribute(FConnectionRequestArchetype.SOCKET, socket);
			fConReq.putAttribute(FConnectionRequestArchetype.MODE, CapabilityMode.BOTH);
			fConReq.putAttribute(FConnectionRequestArchetype.RESTART, false);
			
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

	@Override
	public void inform(Event<?> publication) {
		// TODO Auto-generated method stub
		
	}
}