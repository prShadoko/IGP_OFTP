package oftp.automaton.archetype.monitor.output;

import automaton.event.Field;
import oftp.automaton.archetype.monitor.PositiveFileClosingAcceptationArchetype;

public class PositiveFCloseFileConfirmationArchetype extends PositiveFileClosingAcceptationArchetype {

	public static String NAME = "F_CLOSE_FILE_CS";

	public static final Field<Boolean> SPEAKER = new Field<>("speaker");
	
	public PositiveFCloseFileConfirmationArchetype() {
		super(NAME);

		addField(SPEAKER);
	}

}
