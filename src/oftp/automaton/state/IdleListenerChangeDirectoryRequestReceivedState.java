package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleListenerChangeDirectoryRequestReceivedState extends OftpAbstractState {

	public static final String NAME = "IDLELICD";
	
	public IdleListenerChangeDirectoryRequestReceivedState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
