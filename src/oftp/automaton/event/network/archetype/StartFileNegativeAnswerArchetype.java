package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.CommandCode;
import oftp.automaton.event.network.field.factory.NegativeAnswerReasonFactory;

public class StartFileNegativeAnswerArchetype extends AnswerReasonArchetype {

	public static final String NAME = "SFNA";
	
	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("SFNAREAS" , 2);
	public static final NetworkField<AnswerReason> RETRY_INDICATOR = new NetworkField<>("SFNARRTR" , 1);
	
	public StartFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.SFNA, new NegativeAnswerReasonFactory());

		addField(ANSWER_REASON);
		addField(RETRY_INDICATOR);
	}

}
