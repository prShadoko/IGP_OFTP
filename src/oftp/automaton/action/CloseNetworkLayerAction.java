package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;

public class CloseNetworkLayerAction extends OftpAction {

	public CloseNetworkLayerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		oftp.closeNetworkLayer();
	}

}
