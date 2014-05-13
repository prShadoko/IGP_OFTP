package oftp.automaton.archetype.monitor;

import automaton.event.Field;

public class SessionConnectionInitiationArchetype extends SessionConnectionArchetype {

	public static final Field<String> CALLED_ADDRESS  = new Field<>("called-address");
	public static final Field<String> CALLING_ADDRESS = new Field<>("calling-address");
	
	public SessionConnectionInitiationArchetype(String name) {
		super(name);

		addField(CALLED_ADDRESS);
		addField(CALLING_ADDRESS);
	}
}
