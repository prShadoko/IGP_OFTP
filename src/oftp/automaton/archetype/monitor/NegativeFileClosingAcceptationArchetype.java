package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.PlusMinus;

public class NegativeFileClosingAcceptationArchetype extends PlusMinusArchetype {

	public static final Field<EndSessionAnswerReason> CAUSE = new Field<>("cause");
	
	public NegativeFileClosingAcceptationArchetype(String name) {
		super(name, PlusMinus.MINUS);
		
		addField(CAUSE);
	}

}
