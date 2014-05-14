package oftp.automaton.archetype.monitor.input;

import automaton.event.Field;
import oftp.automaton.AnswerReason;
import oftp.automaton.archetype.monitor.PositiveFileClosingAcceptationArchetype;

public class NegativeFCloseFileResponseArchetype extends PositiveFileClosingAcceptationArchetype {

	public static final String NAME = "F_CLOSE_FILE_RS";

	public static final Field<AnswerReason> ANSWER_REASON = new Field<>("reason");

	public NegativeFCloseFileResponseArchetype() {
		super(NAME);

		addField(ANSWER_REASON);
	}

}
