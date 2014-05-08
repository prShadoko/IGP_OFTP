package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.CommandCode;
import automaton.event.network.NetworkField;

public class StartFilePositiveAnswerArchetype extends OFTPNetworkArchetype {

	public static final String NAME = "SFPA";
	
	public static final NetworkField<Integer> ANSWER_COUNT = new NetworkField<>("SFPAACNT" , 9);
	
	public StartFilePositiveAnswerArchetype() {
		super(NAME, CommandCode.SFPA);
		
		addField(ANSWER_COUNT);
	}

}
