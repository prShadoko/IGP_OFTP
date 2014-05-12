package oftp.automaton.archetype.monitor.input;

import java.net.Socket;

import oftp.automaton.archetype.monitor.MonitorArchetype;
import automaton.event.Field;

public class AbstractSocketInitialisationArchetype extends MonitorArchetype {

	public static final Field<Socket> SOCKET = new Field<>("socket");
	
	public AbstractSocketInitialisationArchetype(String name) {
		super(name);
	}
	
}
