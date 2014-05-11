package oftp.automaton.archetype.monitor.output;

import automaton.event.Field;
import oftp.automaton.archetype.monitor.MonitorArchetype;

public class FDataIndicationArchetype extends MonitorArchetype {

	public static final String NAME = "F_DATA_IND";
	
	public static final Field<Byte[]> DATA = new Field<>("data");
	
	public FDataIndicationArchetype() {
		super(NAME);
		
		addField(DATA);
	}
}
