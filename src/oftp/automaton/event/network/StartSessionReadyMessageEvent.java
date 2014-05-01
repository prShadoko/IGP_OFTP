package oftp.automaton.event.network;

import oftp.automaton.network.Network;

public class StartSessionReadyMessageEvent extends NetworkEvent {

	public static final String NAME = "SSRM";
	
	public static final char COMMAND_CODE = 'I';
	public static final String READY_MESSAGE = "ODETTE FTP READY ";
	
	
	public StartSessionReadyMessageEvent() {
		super(NAME);
	}


	@Override
	public byte[] toBytes() {
		return (COMMAND_CODE + READY_MESSAGE + Network.CR).getBytes();
	}

}
