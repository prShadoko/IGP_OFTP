package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.CommandCode;

public class DataExchangeBufferArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "DATA";

	public static final NetworkField<AnswerReason> DATA_EXCHANGE_BUFFER_PAYLOAD = new NetworkField<>("DATABUF", 0);

	public DataExchangeBufferArchetype() {
		super(NAME, CommandCode.DATA);

		addField(DATA_EXCHANGE_BUFFER_PAYLOAD);
	}

}
