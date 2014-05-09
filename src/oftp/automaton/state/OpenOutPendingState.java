package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class OpenOutPendingState extends OftpAbstractState {

	public static final String NAME = "OPOP";
	
	public OpenOutPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
