package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.CommandCode;

public class ChangeDirectionArchetype extends OftpNetworkArchetype {

	public static final String NAME = "CD";
	
	public ChangeDirectionArchetype() {
		super(NAME, CommandCode.CD);
	}

}
