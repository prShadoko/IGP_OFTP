package oftp.monitor;

import java.io.IOException;
import java.net.Socket;

import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.monitor.output.FAbortIndicationArchetype;
import automaton.event.Archetype;
import automaton.event.Event;
import automaton.event.EventLayer;

public class MonitorInitiator extends EventLayer implements Runnable {

	private String ip;
	private OftpAutomaton oftp;

	public MonitorInitiator(String ip) {
		this.ip = ip;
	}

	@Override
	public void run() {
		try {
			oftp = OftpAutomaton.build(false, CapabilityInit.BOTH, CapabilityMode.BOTH, 999999, 999);
			this.subscribe(MonitorEvent.class, oftp);

			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			Socket socket = new Socket(ip, MonitorAcceptor.LISTEN_PORT);
			MonitorEvent fConReq = new MonitorEvent(new FConnectionRequestArchetype());
			fConReq.putAttribute(FConnectionRequestArchetype.SOCKET, socket);
			fConReq.putAttribute(FConnectionRequestArchetype.MODE, CapabilityMode.BOTH);
			fConReq.putAttribute(FConnectionRequestArchetype.RESTART, false);

			publish(fConReq);

			oftpThread.join();
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MonitorInitiator monitor = new MonitorInitiator("localhost");
		monitor.run();
	}

	@Override
	public void inform(Event<?> inputEvent) {
		Archetype<?> archetype = inputEvent.getArchetype();
		Event<?> event = null;
		if(archetype.equals(new FAbortIndicationArchetype())) {
			oftp.closeNetworkLayer();
		}

		if(null != event) {
			publish(event);
		}
	}
}
