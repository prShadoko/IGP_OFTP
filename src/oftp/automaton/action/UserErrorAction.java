package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;

public class UserErrorAction extends OftpAction {

	public UserErrorAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		System.out.println("User Error !");
		System.out.println("Event " + inputEvent + " not expected.");
	}

}
