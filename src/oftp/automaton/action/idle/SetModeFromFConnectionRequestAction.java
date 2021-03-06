package oftp.automaton.action.idle;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;

public class SetModeFromFConnectionRequestAction extends OftpAction {

	public SetModeFromFConnectionRequestAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		
		switch (oftp.getCapMode()) {
		case BOTH:
			oftp.setMode(inputEvent.getAttribute(FConnectionRequestArchetype.MODE));
			break;

		default:
			oftp.setMode(oftp.getCapMode());
			break;
		}
		oftp.setPassword(inputEvent.getAttribute(FConnectionRequestArchetype.PASSWORD));
		oftp.setId(inputEvent.getAttribute(FConnectionRequestArchetype.ID));
		oftp.setRestartEnabled(inputEvent.getAttribute(FConnectionRequestArchetype.RESTART));
		oftp.setBufferSize(oftp.getMaximumBufferSize());
		oftp.setCompressionEnabled(oftp.isCapCompression());
	}

}
