package oftp.automaton.action;

import automaton.action.Action;
import oftp.automaton.OftpAutomaton;

public abstract class OftpAction implements Action {

	protected OftpAutomaton oftp;
	
	public OftpAction(OftpAutomaton oftp) {
		this.oftp = oftp;
	}

	public OftpAutomaton getAutomaton() {
		return oftp;
	}

}
