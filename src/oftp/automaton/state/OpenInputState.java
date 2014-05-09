package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class OpenInputState extends OftpAbstractState {

	public static final String NAME = "OPI";
	
	public OpenInputState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
