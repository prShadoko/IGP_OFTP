package oftp.automaton.event.monitor;

import java.net.Socket;

import automaton.event.Archetype;
import automaton.event.Field;

public class AbstractSocketInitialisationArchetype extends Archetype<Field<?>> {

	public static final Field<Socket> SOCKET = new Field<>("socket");
	
	public AbstractSocketInitialisationArchetype(String name) {
		super(name);
	}
	
}
