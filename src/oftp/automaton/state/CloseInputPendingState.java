package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class CloseInputPendingState extends OftpAbstractState {

	public static final String NAME = "CLIP";
	
	public CloseInputPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
