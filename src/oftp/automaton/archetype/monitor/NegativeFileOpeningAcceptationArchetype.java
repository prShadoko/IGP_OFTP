package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.NegativeAnswerReason;
import oftp.automaton.PlusMinus;

public class NegativeFileOpeningAcceptationArchetype extends PlusMinusArchetype {

	public static final Field<NegativeAnswerReason> CAUSE       = new Field<>("cause");
	public static final Field<Boolean>              RETRY_LATER = new Field<>("retry-later");
	
	public NegativeFileOpeningAcceptationArchetype(String name) {
		super(name, PlusMinus.MINUS);

		addField(CAUSE);
		addField(RETRY_LATER);
	}

}
