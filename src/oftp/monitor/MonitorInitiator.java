package oftp.monitor;

import automaton.event.Event;
import automaton.event.EventLayer;
import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;

import java.io.IOException;
import java.net.Socket;

public class MonitorInitiator extends EventLayer implements Runnable {

	private String ip;

	public MonitorInitiator(String ip) {
		this.ip = ip;
	}

	@Override
	public void run() {
		try {
			
			OftpAutomaton oftp = OftpAutomaton.build(false, CapabilityInit.BOTH, CapabilityMode.BOTH, 999999, 999);
			this.subscribe(MonitorEvent.class, oftp);
			
			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			Socket socket = new Socket(ip, MonitorAcceptor.LISTEN_PORT);
			MonitorEvent fConReq = new MonitorEvent(new FConnectionRequestArchetype());
			fConReq.putAttribute(FConnectionRequestArchetype.SOCKET, socket);
			
			publish(fConReq);
			
			oftpThread.join();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MonitorInitiator monitor = new MonitorInitiator(args[0]);
		monitor.run();
	}

	@Override
	public void inform(Event<?> publication) {
		// TODO Auto-generated method stub
		
	}
}
