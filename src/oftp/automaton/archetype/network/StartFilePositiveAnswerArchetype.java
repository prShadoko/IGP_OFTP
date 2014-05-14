package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import oftp.automaton.network.IntegerNetworkField;

public class StartFilePositiveAnswerArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SFPA";
	
	public static final IntegerNetworkField ANSWER_COUNT = new IntegerNetworkField("SFPAACNT" , 9);
	
	public StartFilePositiveAnswerArchetype() {
		super(NAME, CommandCode.SFPA);
		
		addField(ANSWER_COUNT);
	}

}
