package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class OpenInputPendingState extends OftpAbstractState {

	public static final String NAME = "OPIP";
	
	public OpenInputPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
