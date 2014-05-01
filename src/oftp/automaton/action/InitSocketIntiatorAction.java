package oftp.automaton.action;

import java.io.IOException;
import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import automaton.event.Event;

public class InitSocketIntiatorAction extends OFTPAction {
	
	public InitSocketIntiatorAction(OFTPAutomaton automaton) {
		super(automaton);
	}
	
	@Override
	public void execute(Event inputEvent) {
		String address = (String) inputEvent.getAttribute("address");
		int port = (int) inputEvent.getAttribute("port");
		
		try {
			Socket socket = new Socket(address, port);
			
			automaton.setSocket(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
