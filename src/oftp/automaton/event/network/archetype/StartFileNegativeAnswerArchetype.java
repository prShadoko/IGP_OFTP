package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.CommandCode;

public class StartFileNegativeAnswerArchetype extends NegativeAnswerArchetype {

	public static final String NAME = "SFNA";

	public static final NetworkField<AnswerReason> RETRY_INDICATOR = new NetworkField<>("SFNARRTR" , 1);
	
	public StartFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.SFNA);

		addField(RETRY_INDICATOR);
	}

}
