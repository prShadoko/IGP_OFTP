package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import oftp.automaton.network.FileFormatNetworkField;
import oftp.automaton.network.IntegerNetworkField;
import automaton.event.network.NetworkField;

public class StartFileArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SFID";

	public static NetworkField<String> 		VIRTUAL_FILE_DATA_SET_NAME 	= new NetworkField<>("SFIDDSN",   26);
	public static NetworkField<String> 		RESERVED 					= new NetworkField<>("SFIDRSV1",  9, "         ");
	public static NetworkField<String> 		VIRTUAL_FILE_DATE_STAMP 	= new NetworkField<>("SFIDDATE",  6);
	public static NetworkField<String> 		VIRTUAL_FILE_TIME_STAMP 	= new NetworkField<>("SFIDTIME",  6);
	public static NetworkField<String> 		USER_DATA 					= new NetworkField<>("SFIDUSER",  8, "        ");
	public static NetworkField<String> 		DESTINATION 				= new NetworkField<>("SFIDDEST",  25);
	public static NetworkField<String> 		ORIGINATOR 					= new NetworkField<>("SFIDORIG",  25);
	public static FileFormatNetworkField 	FILE_FORMAT 				= new FileFormatNetworkField("SFIDFMT");
	public static IntegerNetworkField 	MAXIMUM_RECORD_SIZE 		= new IntegerNetworkField("SFIDLRECL", 5);
	public static IntegerNetworkField 	FILE_SIZE 					= new IntegerNetworkField("SFIDFSIZ",  7);
	public static IntegerNetworkField 	RESTART_POSITION 			= new IntegerNetworkField("SFIDREST",  9);
	
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
