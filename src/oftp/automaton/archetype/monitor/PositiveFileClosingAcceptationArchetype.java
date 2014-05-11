package oftp.automaton.archetype.monitor;

import oftp.automaton.PlusMinus;
import automaton.event.Field;

public class PositiveFileClosingAcceptationArchetype extends PlusMinusArchetype {

	public static final Field<Boolean> SPEAKER = new Field<>("Speaker");
	
	public PositiveFileClosingAcceptationArchetype(String name) {
		super(name, PlusMinus.PLUS);
	}

}
