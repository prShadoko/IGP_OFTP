package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import automaton.action.Action;

public abstract class OftpAction implements Action {

	protected OftpAutomaton automaton;
	
	public OftpAction(OftpAutomaton automaton) {
		this.automaton = automaton;
	}

	public OftpAutomaton getAutomaton() {
		return automaton;
	}

}
