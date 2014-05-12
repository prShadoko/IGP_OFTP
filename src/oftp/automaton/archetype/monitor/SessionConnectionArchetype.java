package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.CapabilityMode;

public class SessionConnectionArchetype extends MonitorArchetype {

	public static final Field<String>         ID       = new Field<>("ID");
	public static final Field<String>         PASSWORD = new Field<>("PSW");
	public static final Field<CapabilityMode> MODE     = new Field<>("mode");
	public static final Field<Boolean>        RESTART  = new Field<>("restart");
	
	public SessionConnectionArchetype(String name) {
		super(name);

		addField(ID);
		addField(PASSWORD);
		addField(MODE);
		addField(RESTART);
	}
}
