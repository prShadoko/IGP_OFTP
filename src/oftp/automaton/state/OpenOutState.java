package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class OpenOutState extends OftpAbstractState {

	public static final String NAME = "OPO";
	
	public OpenOutState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
