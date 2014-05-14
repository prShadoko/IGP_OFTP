package oftp.automaton.archetype.monitor;

import automaton.event.Field;

public class FileClosingInitiationArchetype extends MonitorArchetype {

	public static final Field<Integer> RECORD_COUNT = new Field<>("rec-count");
	public static final Field<Integer> UNIT_COUNT   = new Field<>("unit-count");
	
	public FileClosingInitiationArchetype(String name) {
		super(name);
		
		addField(RECORD_COUNT);
		addField(UNIT_COUNT);
	}

}
