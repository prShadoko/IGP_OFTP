package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import automaton.action.Action;

public abstract class OftpAction implements Action {

	protected OftpAutomaton oftp;
	
	public OftpAction(OftpAutomaton oftp) {
		this.oftp = oftp;
	}

	public OftpAutomaton getAutomaton() {
		return oftp;
	}

}
