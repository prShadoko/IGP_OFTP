package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class EndToEndresponseArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "EERP";

	public static final NetworkField<String> VIRTUAL_FILE_DATASET_NAME = new NetworkField<String>("EERPDSN", 26);
	public static final NetworkField<String> RESERVED = new NetworkField<String>("EERPRSV1", 26);
	public static final NetworkField<String> VIRTUAL_FILE_DATE_STAMP = new NetworkField<String>("EERPDATE", 26);
	public static final NetworkField<String> VIRTUAL_FILE_TIME_STAMP = new NetworkField<String>("EERPTIME", 26);
	public static final NetworkField<String> USER_DATA  = new NetworkField<String>("EERPUSER", 26);
	public static final NetworkField<String> DESTINATION = new NetworkField<String>("EERPDEST", 26);
	public static final NetworkField<String> ORIGINATOR = new NetworkField<String>("EERPORIG", 26);
	
	public EndToEndresponseArchetype() {
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
