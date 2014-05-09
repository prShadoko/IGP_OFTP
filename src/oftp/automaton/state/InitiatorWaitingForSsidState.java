package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class InitiatorWaitingForSsidState extends OftpAbstractState {

	public static final String NAME = "I_WF_SSID";
	
	public InitiatorWaitingForSsidState(OftpAutomaton oftp) {
		super(oftp, NAME);
		
	}
}
