package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.CommandCode;

public class SetCreditArchetype extends OftpNetworkArchetype {

	public static final String NAME = "CDT";
	
	public static final NetworkField<String> RESERVED = new NetworkField<>("CDTRSV1", 2);
	
	public SetCreditArchetype() {
		super(NAME, CommandCode.CDT);
		
		addField(RESERVED);
	}

}
