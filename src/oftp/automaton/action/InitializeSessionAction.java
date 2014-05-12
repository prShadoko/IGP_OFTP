package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;

public class InitializeSessionAction extends OftpAction {

	public InitializeSessionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		oftp.setMode(inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY));
		oftp.setRestart(inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION));
		oftp.setCompression(inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION));
		oftp.setBufferSize(inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE));
		oftp.setCreditSpeaker(inputEvent.getAttribute(StartSessionArchetype.CREDIT));
	}

}
