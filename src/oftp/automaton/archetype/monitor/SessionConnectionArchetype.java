package oftp.automaton.archetype.monitor;

import automaton.event.Field;

public class SessionConnectionArchetype extends MonitorArchetype {

	public static final Field<String> ID = new Field<>("ID1");
	public static final Field<String> PASSWORD = new Field<>("PSW1");
	public static final Field<String> MODEL = new Field<>("mode1");
	public static final Field<String> RESTART = new Field<>("restart1");
	
	public SessionConnectionArchetype(String name) {
		super(name);

		addField(ID);
		addField(PASSWORD);
		addField(MODEL);
		addField(RESTART);
	}

}
