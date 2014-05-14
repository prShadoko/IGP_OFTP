package oftp.automaton.action.awfconrs;

import automaton.action.Action;
import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.InitializeInitiatorSessionAction;
import oftp.automaton.action.OftpAction;

public class InitializeAcceptorSessionAction extends OftpAction {

	public InitializeAcceptorSessionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Action a = new InitializeInitiatorSessionAction(oftp);
		a.execute(oftp.getSsid());
	}

}
