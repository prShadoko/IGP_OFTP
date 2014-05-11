package oftp.automaton.action;

import java.net.Socket;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.input.AbstractSocketInitialisationArchetype;
import automaton.event.Event;

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
