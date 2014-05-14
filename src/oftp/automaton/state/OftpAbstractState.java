package oftp.automaton.state;

import automaton.state.StateImpl;
import oftp.automaton.OftpAutomaton;

public abstract class OftpAbstractState extends StateImpl {

	protected OftpAutomaton oftp;
	
	public OftpAbstractState(OftpAutomaton oftp, String name) {
		super(name);
		this.oftp = oftp;
	}

}
