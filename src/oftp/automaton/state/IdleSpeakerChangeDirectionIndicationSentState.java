package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleSpeakerChangeDirectionIndicationSentState extends OftpAbstractState {

	public static final String NAME = "IDLESPCD";
	
	public IdleSpeakerChangeDirectionIndicationSentState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
