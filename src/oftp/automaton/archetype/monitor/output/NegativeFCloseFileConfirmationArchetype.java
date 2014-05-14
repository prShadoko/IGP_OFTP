package oftp.automaton.archetype.monitor.output;

import automaton.event.Field;
import oftp.automaton.AnswerReason;
import oftp.automaton.archetype.monitor.MonitorArchetype;

public class NegativeFCloseFileConfirmationArchetype extends MonitorArchetype {

	public static String NAME = "F_CLOSE_FILE_CS";

	public static final Field<AnswerReason> ANSWER_REASON = new Field<>("reason");

	public NegativeFCloseFileConfirmationArchetype() {
		super(NAME);

		addField(ANSWER_REASON);
	}
}
