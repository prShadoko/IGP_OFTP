package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import automaton.action.Action;

public abstract class OftpAction implements Action {

	protected OftpAutomaton oftp;
	
	public OftpAction(OftpAutomaton automaton) {
		this.oftp = automaton;
	}

	public OftpAutomaton getAutomaton() {
		return oftp;
	}

}
