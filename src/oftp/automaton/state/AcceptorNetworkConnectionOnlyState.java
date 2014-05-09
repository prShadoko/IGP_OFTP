package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;

public class AcceptorNetworkConnectionOnlyState extends OftpAbstractState {

	public static final String NAME = "A_NC_ONLY";
	
	public AcceptorNetworkConnectionOnlyState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}


}
