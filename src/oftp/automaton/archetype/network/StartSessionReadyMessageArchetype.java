package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.CommandCode;
import oftp.automaton.network.OftpNetworkField;

public class StartSessionReadyMessageArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SSRM";

	public static final NetworkField<String> READY_MESSAGE = new NetworkField<>("SSRMMSG", 17, "ODETTE FTP READY ");
	
	
	public StartSessionReadyMessageArchetype() {
		super(NAME, CommandCode.SSRM);
		
		addField(READY_MESSAGE);
		addField(OftpNetworkField.CR);
	}
}
