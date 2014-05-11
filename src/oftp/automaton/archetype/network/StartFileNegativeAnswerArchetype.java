package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.AnswerReason;
import oftp.automaton.CommandCode;
import oftp.automaton.NegativeAnswerReason;

public class StartFileNegativeAnswerArchetype extends AnswerReasonArchetype {

	public static final String NAME = "SFNA";
	
	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("SFNAREAS" , 2);
	public static final NetworkField<AnswerReason> RETRY_INDICATOR = new NetworkField<>("SFNARRTR" , 1);
	
	public StartFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.SFNA, new NegativeAnswerReason());

		addField(ANSWER_REASON);
		addField(RETRY_INDICATOR);
	}

}
