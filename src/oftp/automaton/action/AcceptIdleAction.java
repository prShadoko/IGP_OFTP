package oftp.automaton.action;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import oftp.automaton.network.NetworkLayer;
import automaton.event.Event;

public class AcceptIdleAction extends OFTPAction  {

	public AcceptIdleAction(OFTPAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event inputEvent) {
		try {
			ServerSocket serverSocket = automaton.getServerSocket();
			
			Socket socket = serverSocket.accept();
			
			NetworkLayer listener = new NetworkLayer(socket);
			automaton.setNetworkListener(listener);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
