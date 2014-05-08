package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class SetCreditArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "CDT";
	
	public static final NetworkField<String> RESERVED = new NetworkField<>("CDTRSV1", 2);
	
	public SetCreditArchetype() {
		super(NAME, CommandCode.CDT);
		
		addField(RESERVED);
	}

}
