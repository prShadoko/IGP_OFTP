package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.CommandCode;
import oftp.automaton.YesNo;
import oftp.automaton.network.IntegerNetworkField;
import oftp.automaton.network.ModeNetworkField;
import oftp.automaton.network.OftpNetworkField;
import oftp.automaton.network.YesNoNetworkField;

public class StartSessionArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SSID";

	public static final IntegerNetworkField 	        LEVEL 						= new IntegerNetworkField("SSIDLEV", 	1, 	1);
	public static final NetworkField<String> 	        CODE						= new NetworkField<>("SSIDCODE", 	25);
	public static final NetworkField<String> 	        PASSWORD 					= new NetworkField<>("SSIDPSWD", 	8);
	public static final IntegerNetworkField 	        EXCHANGE_BUFFER_SIZE 		= new IntegerNetworkField("SSIDSDEB", 	5);
	public static final ModeNetworkField			    SEND_RECEIVE_CAPABILITY 	= new ModeNetworkField("SSIDSR");
	public static final YesNoNetworkField               COMPRESSION_INDICATION 		= new YesNoNetworkField("SSIDCMPR", 	YesNo.NO);
	public static final YesNoNetworkField               RESTART_INDICATION 			= new YesNoNetworkField("SSIDREST",  	YesNo.NO);
	public static final YesNoNetworkField               SPECIAL_LOGIC_INDICATION 	= new YesNoNetworkField("SSIDSPEC", 	YesNo.NO);
	public static final IntegerNetworkField 	        CREDIT 						= new IntegerNetworkField("SSIDCRED", 	3);
	public static final NetworkField<String> 	        RESERVED 					= new NetworkField<>("SSIDRSV1", 	5,  "     ");
	public static final NetworkField<String> 	        USER_DATA 					= new NetworkField<>("SSIDUSER",	8,  "        ");

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
