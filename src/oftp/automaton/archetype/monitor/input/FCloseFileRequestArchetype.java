package oftp.automaton.archetype.monitor.input;

import oftp.automaton.archetype.monitor.FileClosingInitiationArchetype;

public class FCloseFileRequestArchetype extends FileClosingInitiationArchetype {

	public static final String NAME = "F_CLOSE_FILE_RQ";
	
	public FCloseFileRequestArchetype() {
		super(NAME);
	}

}
