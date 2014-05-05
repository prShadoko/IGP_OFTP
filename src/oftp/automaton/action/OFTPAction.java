package oftp.automaton.action;

import oftp.automaton.OFTPAutomaton;
import automaton.action.Action;

public abstract class OFTPAction implements Action {

	protected OFTPAutomaton automaton;
	
	public OFTPAction(OFTPAutomaton automaton) {
		this.automaton = automaton;
	}

	public OFTPAutomaton getAutomaton() {
		return automaton;
	}

}
