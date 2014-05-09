package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkField;
import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.CommandCode;
import oftp.automaton.event.network.field.factory.NegativeAnswerReasonFactory;

public class EndFileNegativeAnswerArchetype extends AnswerReasonArchetype {

	public static final String NAME = "EFNA";
	
	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("EFNAREAS" , 2);
	
	public EndFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.EFNA, new NegativeAnswerReasonFactory());
		
		addField(ANSWER_REASON);
	}
	

}
