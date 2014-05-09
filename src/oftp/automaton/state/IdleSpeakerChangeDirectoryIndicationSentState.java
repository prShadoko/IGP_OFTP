package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleSpeakerChangeDirectoryIndicationSentState extends OftpAbstractState {

	public static final String NAME = "IDLESPCD";
	
	public IdleSpeakerChangeDirectoryIndicationSentState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
}
