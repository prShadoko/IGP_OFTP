package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.AnswerReason;
import oftp.automaton.CommandCode;
import oftp.automaton.NegativeAnswerReason;
import oftp.automaton.network.YesNoNetworkField;

public class StartFileNegativeAnswerArchetype extends AnswerReasonArchetype {

	public static final String NAME = "SFNA";
	
	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("SFNAREAS" , 2);
	public static final YesNoNetworkField RETRY_INDICATOR = new YesNoNetworkField("SFNARRTR");
	
	public StartFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.SFNA, new NegativeAnswerReason());

		addField(ANSWER_REASON);
		addField(RETRY_INDICATOR);
	}

}
