package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.PlusMinus;

public class PositiveFileOpeningAcceptationArchetype extends MonitorArchetype {

    public static final Field<String> RESTART_POSITION = FileOpeningInitiationArchetype.RESTART_POSITION;
    
	public PositiveFileOpeningAcceptationArchetype(String name) {
		super(name+"("+PlusMinus.PLUS+")");
			
		addField(RESTART_POSITION);
	}

}
