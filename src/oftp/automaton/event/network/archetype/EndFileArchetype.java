package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class EndFileArchetype extends OftpNetworkArchetype {

	public static final String NAME = "EFID";

    public static final NetworkField<Integer> RECORD_COUNT = new NetworkField<>("EFIDRCNT", 9);
    public static final NetworkField<Integer> UNIT_COUNT   = new NetworkField<>("EFIDUCNT", 12);
	
	public EndFileArchetype() {
		super(NAME, CommandCode.EFID);

		addField(RECORD_COUNT);
		addField(UNIT_COUNT);
	}

}
