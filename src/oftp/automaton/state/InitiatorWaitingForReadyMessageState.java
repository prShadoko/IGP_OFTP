package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;

public class InitiatorWaitingForReadyMessageState extends OftpAbstractState {

	public static final String NAME = "I_WF_RM";
	
	public InitiatorWaitingForReadyMessageState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}

}
