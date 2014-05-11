package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import automaton.event.network.NetworkField;

public class StartFilePositiveAnswerArchetype extends OftpNetworkArchetype {

	public static final String NAME = "SFPA";
	
	public static final NetworkField<Integer> ANSWER_COUNT = new NetworkField<>("SFPAACNT" , 9);
	
	public StartFilePositiveAnswerArchetype() {
		super(NAME, CommandCode.SFPA);
		
		addField(ANSWER_COUNT);
	}

}
