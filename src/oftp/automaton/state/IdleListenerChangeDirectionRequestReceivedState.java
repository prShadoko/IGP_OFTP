package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleListenerChangeDirectionRequestReceivedState extends OftpAbstractState {

	public static final String NAME = "IDLELICD";
	
	public IdleListenerChangeDirectionRequestReceivedState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
