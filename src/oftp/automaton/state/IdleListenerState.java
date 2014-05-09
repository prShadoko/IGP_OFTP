package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleListenerState extends OftpAbstractState {

	public static final String NAME = "IDLELI";
	
	public IdleListenerState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
