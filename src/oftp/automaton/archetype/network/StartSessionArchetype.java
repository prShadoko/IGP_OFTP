package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import oftp.automaton.network.OftpNetworkField;
import automaton.event.network.NetworkField;

public class StartSessionArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SSID";

	public static final NetworkField<Integer> 	LEVEL 						= new NetworkField<>("SSIDLEV", 	1, 	1);
	public static final NetworkField<String> 	CODE						= new NetworkField<>("SSIDCODE", 	25);
	public static final NetworkField<String> 	PASSWORD 					= new NetworkField<>("SSIDPSWD", 	8);
	public static final NetworkField<Integer> 	EXCHANGE_BUFFER_SIZE 		= new NetworkField<>("SSIDSDEB", 	5);
	public static final NetworkField<Character> SEND_RECEIVE_CAPABILITY 	= new NetworkField<>("SSIDSR", 		1);
	public static final NetworkField<Character> COMPRESSION_INDICATION 		= new NetworkField<>("SSIDCMPR", 	1, 	'N');
	public static final NetworkField<Character> RESTART_INDICATION 			= new NetworkField<>("SSIDREST", 	1, 	'N');
	public static final NetworkField<Character> SPECIAL_LOGIC_INDICATION 	= new NetworkField<>("SSIDSPEC", 	1, 	'N');
	public static final NetworkField<Integer> 	CREDIT 						= new NetworkField<>("SSIDCRED", 	3);
	public static final NetworkField<String> 	RESERVED 					= new NetworkField<>("SSIDRSV1", 	5);
	public static final NetworkField<String> 	USER_DATA 					= new NetworkField<>("SSIDUSER",	8);

	public StartSessionArchetype() {
		super(NAME, CommandCode.SSID);

		addField(LEVEL);
		addField(CODE);
		addField(PASSWORD);
		addField(EXCHANGE_BUFFER_SIZE);
		addField(SEND_RECEIVE_CAPABILITY);
		addField(COMPRESSION_INDICATION);
		addField(RESTART_INDICATION);
		addField(SPECIAL_LOGIC_INDICATION);
		addField(CREDIT);
		addField(RESERVED);
		addField(USER_DATA);
		addField(OftpNetworkField.CR);
	}
}
