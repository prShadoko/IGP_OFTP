package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.OFTPNetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class StartSessionReadyMessageArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "SSRM";

	public static final NetworkField<String> READY_MESSAGE = new NetworkField<>("SSRMMSG", 17, "ODETTE FTP READY ");
	
	
	public StartSessionReadyMessageArchetype() {
		super(NAME, CommandCode.SSRM);
		
		addField(READY_MESSAGE);
		addField(OFTPNetworkField.CR);
	}
}
