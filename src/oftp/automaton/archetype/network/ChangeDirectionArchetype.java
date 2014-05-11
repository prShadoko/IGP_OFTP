package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;

public class ChangeDirectionArchetype extends OftpNetworkArchetype {

	public static final String NAME = "CD";
	
	public ChangeDirectionArchetype() {
		super(NAME, CommandCode.CD);
	}

}
