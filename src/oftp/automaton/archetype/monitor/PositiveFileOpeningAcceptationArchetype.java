package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.PlusMinus;

public class PositiveFileOpeningAcceptationArchetype extends PlusMinusArchetype {

    public static final Field<String> RESTART_POSITION = FileOpeningInitiationArchetype.RESTART_POSITION;
    
	public PositiveFileOpeningAcceptationArchetype(String name) {
		super(name, PlusMinus.PLUS);
			
		addField(RESTART_POSITION);
	}

}
