package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleSpeakerState extends OftpAbstractState {

	public static final String NAME = "IDLESP";
	
	public IdleSpeakerState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
