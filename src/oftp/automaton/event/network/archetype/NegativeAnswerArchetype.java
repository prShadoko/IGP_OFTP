package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.AnswerReason;
import automaton.event.network.NetworkField;

public class NegativeAnswerArchetype extends OFTPNetworkArchetype {

	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("SFNAREAS" , 2);

	public NegativeAnswerArchetype(String name, char commandCode) {
		super(name, commandCode);

		addField(ANSWER_REASON);
	}

}
