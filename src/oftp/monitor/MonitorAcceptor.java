package oftp.monitor;

import automaton.event.Archetype;
import automaton.event.Event;
import automaton.event.EventLayer;
import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.AbstractSocketInitialisationArchetype;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.monitor.input.NetworkConnectionIndicationArchetype;
import oftp.automaton.archetype.monitor.output.FAbortIndicationArchetype;
import oftp.automaton.archetype.monitor.output.FConnectionIndicationArchetype;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MonitorAcceptor extends EventLayer implements Runnable {

	public static final int LISTEN_PORT = 10101;

	OftpAutomaton oftp;

	@Override
	public void run() {
		try {
			oftp = OftpAutomaton.build(false, CapabilityInit.BOTH, CapabilityMode.BOTH, 999999, 999);
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
		} catch(IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MonitorAcceptor monitor = new MonitorAcceptor();
		monitor.run();
	}

	@Override
	public void inform(Event<?> inputEvent) {
		Archetype<?> archetype = inputEvent.getArchetype();
		Event<?> event = null;
		if(archetype.equals(new FAbortIndicationArchetype())) {
			oftp.closeNetworkLayer();
		} else if(archetype.equals(new FConnectionIndicationArchetype())) {
			event = new MonitorEvent(new FConnectionResponseArchetype());
			event.putAttribute(FConnectionResponseArchetype.ID, "azertyuiiopqsdfghjklmwxcv");
			event.putAttribute(FConnectionResponseArchetype.PASSWORD, "azertyuiiopqsdfghjklmwxcv");
			event.putAttribute(FConnectionResponseArchetype.MODE, CapabilityMode.BOTH);
			event.putAttribute(FConnectionResponseArchetype.RESTART, false);
		}

		if(null != event) {
			publish(event);
		}
	}
}
