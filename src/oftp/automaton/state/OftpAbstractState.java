package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;
import automaton.state.StateImpl;

public abstract class OftpAbstractState extends StateImpl {

	protected OftpAutomaton oftp;
	
	public OftpAbstractState(OftpAutomaton oftp, String name) {
		super(name);
		this.oftp = oftp;
	}

}
