package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.CommandCode;

public class ReadyToReceiveArchetype extends OftpNetworkArchetype {

	public static final String NAME = "RTR";
	
	public ReadyToReceiveArchetype() {
		super(NAME, CommandCode.RTR);
	}

}
