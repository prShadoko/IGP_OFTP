package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class StartFileArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "SFID";

	public static NetworkField<String> 		VIRTUAL_FILE_DATA_SET_NAME 	= new NetworkField<>("SFIDDSN",   26);
	public static NetworkField<String> 		RESERVED 					= new NetworkField<>("SFIDRSV1",  9);
	public static NetworkField<String> 		VIRTUAL_FILE_DATE_STAMP 	= new NetworkField<>("SFIDDATE",  6);
	public static NetworkField<String> 		VIRTUAL_FILE_TIME_STAMP 	= new NetworkField<>("SFIDTIME",  6);
	public static NetworkField<String> 		USER_DATA 					= new NetworkField<>("SFIDUSER",  8);
	public static NetworkField<String> 		DESTINATION 				= new NetworkField<>("SFIDDEST",  25);
	public static NetworkField<String> 		ORIGINATOR 					= new NetworkField<>("SFIDORIG",  25);
	public static NetworkField<Character> 	FILE_FORMAT 				= new NetworkField<>("SFIDFMT",   1);
	public static NetworkField<Integer> 	MAXIMUM_RECORD_SIZE 		= new NetworkField<>("SFIDLRECL", 5);
	public static NetworkField<Integer> 	FILE_SIZE 					= new NetworkField<>("SFIDFSIZ",  7);
	public static NetworkField<Integer> 	RESTART_POSITION 			= new NetworkField<>("SFIDREST",  9);
	
	public StartFileArchetype() {
		super(NAME, CommandCode.SFID);

		addField(VIRTUAL_FILE_DATA_SET_NAME);
		addField(RESERVED);
		addField(VIRTUAL_FILE_DATE_STAMP);
		addField(VIRTUAL_FILE_TIME_STAMP);
		addField(USER_DATA);
		addField(DESTINATION);
		addField(ORIGINATOR);
		addField(FILE_FORMAT);
		addField(MAXIMUM_RECORD_SIZE);
		addField(FILE_SIZE);
		addField(RESTART_POSITION);
	}

}
