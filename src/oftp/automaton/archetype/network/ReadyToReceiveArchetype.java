package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;

public class ReadyToReceiveArchetype extends OftpNetworkArchetype {

	public static final String NAME = "RTR";
	
	public ReadyToReceiveArchetype() {
		super(NAME, CommandCode.RTR);
	}

}
