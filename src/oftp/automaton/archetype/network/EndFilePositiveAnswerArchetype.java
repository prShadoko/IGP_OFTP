package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import oftp.automaton.network.YesNoNetworkField;

public class EndFilePositiveAnswerArchetype extends OftpNetworkArchetype {

	public static final String NAME = "EFPA";

    public static final YesNoNetworkField CHANGE_DIRECTION_INDICATOR = new YesNoNetworkField("EFPACD");
	
	public EndFilePositiveAnswerArchetype() {
		super(NAME, CommandCode.EFPA);

		addField(CHANGE_DIRECTION_INDICATOR);
	}

}
