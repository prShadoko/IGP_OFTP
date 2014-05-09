package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;

public class AcceptorWaitingForConnectionResponseState extends OftpAbstractState {

	public static final String NAME = "A_WF_CONRS";
	
	public AcceptorWaitingForConnectionResponseState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}


}
