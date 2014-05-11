package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;

public class CloseNetworkLayerAction extends OftpAction {

	public CloseNetworkLayerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		oftp.closeNetworkLayer();
	}

}
