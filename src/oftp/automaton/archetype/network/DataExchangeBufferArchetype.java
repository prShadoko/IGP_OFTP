package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import automaton.event.network.NetworkField;

public class DataExchangeBufferArchetype extends OftpNetworkArchetype {

	public static final String NAME = "DATA";

	public static final NetworkField<byte[]> DATA_EXCHANGE_BUFFER_PAYLOAD = new NetworkField<>("DATABUF", 0);

	public DataExchangeBufferArchetype() {
		super(NAME, CommandCode.DATA);

		addField(DATA_EXCHANGE_BUFFER_PAYLOAD);
	}

}
