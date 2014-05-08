package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.CommandCode;

public class EndFilePositiveAnswerArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "EFPA";

    public static final NetworkField<Character> CHANGE_DIRECTION_INDICATOR = new NetworkField<>("EFPACD", 1);
	
	public EndFilePositiveAnswerArchetype() {
		super(NAME, CommandCode.EFPA);

		addField(CHANGE_DIRECTION_INDICATOR);
	}

}
