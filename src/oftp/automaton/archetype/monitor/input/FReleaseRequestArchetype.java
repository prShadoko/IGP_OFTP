package oftp.automaton.archetype.monitor.input;

import automaton.event.Field;
import oftp.automaton.AnswerReason;
import oftp.automaton.archetype.monitor.FileClosingInitiationArchetype;

public class FReleaseRequestArchetype extends FileClosingInitiationArchetype {

	public static final String              NAME   = "F_REL_RQ";
	public static final Field<AnswerReason> REASON = new Field<>("reason");

	public FReleaseRequestArchetype() {
		super(NAME);
		addField(REASON);
	}
}
