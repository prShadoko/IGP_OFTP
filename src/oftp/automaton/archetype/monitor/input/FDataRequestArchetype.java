package oftp.automaton.archetype.monitor.input;

import automaton.event.Field;
import oftp.automaton.archetype.monitor.MonitorArchetype;


public class FDataRequestArchetype extends MonitorArchetype {

	public static final String NAME = "F_DATA_RQ";
	
	public static final Field<byte[]> F_DATA = new Field<>("F_DATA");
	
	public FDataRequestArchetype() {
		super(NAME);
		
		addField(F_DATA);
	}

}
