package oftp.automaton.action.awfconrs;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.InitializeInitiatorSessionAction;
import oftp.automaton.action.OftpAction;
import automaton.action.Action;
import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;

public class InitializeAcceptorSessionAction extends OftpAction {

	public InitializeAcceptorSessionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Action a = new InitializeInitiatorSessionAction(oftp);
		a.execute(oftp.getSsid());
	}

}
