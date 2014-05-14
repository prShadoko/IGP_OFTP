package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.service.OftpNetworkArchetypeProviderService;

public class InitializeInitiatorSessionAction extends OftpAction {

	public InitializeInitiatorSessionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		oftp.setMode(inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY));
		oftp.setRestartEnabled(inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION).toBoolean());
		oftp.setCompressionEnabled(inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION).toBoolean());
		oftp.setBufferSize(inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE));
		oftp.setCreditSpeaker(inputEvent.getAttribute(StartSessionArchetype.CREDIT));

		oftp.getNetworkEventFactory().clear();
		oftp.getNetworkEventFactory().addArchetypes(new OftpNetworkArchetypeProviderService().getArchetype(oftp.getBufferSize()));
	}

}
