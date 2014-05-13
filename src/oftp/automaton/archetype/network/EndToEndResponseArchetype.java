package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.CommandCode;

public class EndToEndResponseArchetype extends OftpNetworkArchetype {

	public static final String NAME = "EERP";

	public static final NetworkField<String> VIRTUAL_FILE_DATASET_NAME = new NetworkField<>("EERPDSN",  26);
	public static final NetworkField<String> RESERVED                  = new NetworkField<>("EERPRSV1", 26);
	public static final NetworkField<String> VIRTUAL_FILE_DATE_STAMP   = new NetworkField<>("EERPDATE", 26);
	public static final NetworkField<String> VIRTUAL_FILE_TIME_STAMP   = new NetworkField<>("EERPTIME", 26);
	public static final NetworkField<String> USER_DATA                 = new NetworkField<>("EERPUSER", 26);
	public static final NetworkField<String> DESTINATION               = new NetworkField<>("EERPDEST", 26);
	public static final NetworkField<String> ORIGINATOR                = new NetworkField<>("EERPORIG", 26);

	public EndToEndResponseArchetype() {
		super(NAME, CommandCode.EERP);

		addField(VIRTUAL_FILE_DATASET_NAME);
		addField(RESERVED);
		addField(VIRTUAL_FILE_DATE_STAMP);
		addField(VIRTUAL_FILE_TIME_STAMP);
		addField(USER_DATA);
		addField(DESTINATION);
		addField(ORIGINATOR);
	}
}
