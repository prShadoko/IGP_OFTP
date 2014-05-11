package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.AnswerReason;
import oftp.automaton.CommandCode;
import oftp.automaton.NegativeAnswerReason;

public class EndFileNegativeAnswerArchetype extends AnswerReasonArchetype {

	public static final String NAME = "EFNA";
	
	public static final NetworkField<AnswerReason> ANSWER_REASON = new NetworkField<>("EFNAREAS" , 2);
	
	public EndFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.EFNA, new NegativeAnswerReason());
		
		addField(ANSWER_REASON);
	}
	

}
