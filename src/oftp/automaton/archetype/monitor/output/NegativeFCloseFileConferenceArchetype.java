package oftp.automaton.archetype.monitor.output;

import oftp.automaton.archetype.monitor.NegativeFileClosingAcceptationArchetype;

public class NegativeFCloseFileConferenceArchetype extends NegativeFileClosingAcceptationArchetype {

	public static final String NAME = "F_CLOSE_FILE_RQ";
	
	public NegativeFCloseFileConferenceArchetype() {
		super(NAME);
	}

}
