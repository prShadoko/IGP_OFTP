package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.PlusMinus;

public class PositiveFileClosingAcceptationArchetype extends PlusMinusArchetype {

	public static final Field<Boolean> SPEAKER = new Field<>("Speaker");
	
	public PositiveFileClosingAcceptationArchetype(String name) {
		super(name, PlusMinus.PLUS);
	}

}
