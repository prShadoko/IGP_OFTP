package oftp.automaton.action;

import java.net.Socket;

import oftp.automaton.OFTPAutomaton;
import automaton.event.Event;

public class InitSocketAction extends OFTPAction {

	public InitSocketAction(OFTPAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event inputEvent) {
		Socket socket = (Socket) inputEvent.getAttribute("socket");
		
		automaton.setSocket(socket);
	}

}
