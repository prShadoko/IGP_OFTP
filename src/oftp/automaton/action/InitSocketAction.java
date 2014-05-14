package oftp.automaton.action;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.input.AbstractSocketInitialisationArchetype;

import java.net.Socket;

public class InitSocketAction extends OftpAction {

	public InitSocketAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		Socket socket = inputEvent.getAttribute(AbstractSocketInitialisationArchetype.SOCKET);
		oftp.setSocket(socket);
	}

}
