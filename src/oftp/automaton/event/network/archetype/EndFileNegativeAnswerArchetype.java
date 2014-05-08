package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.CommandCode;

public class EndFileNegativeAnswerArchetype extends NegativeAnswerArchetype {

	public static final String NAME = "EFNA";
	
	public EndFileNegativeAnswerArchetype() {
		super(NAME, CommandCode.EFNA);
	}
	

}
