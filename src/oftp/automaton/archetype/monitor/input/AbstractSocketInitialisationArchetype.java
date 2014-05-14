package oftp.automaton.archetype.monitor.input;

import automaton.event.Field;
import oftp.automaton.archetype.monitor.MonitorArchetype;

import java.net.Socket;

public class AbstractSocketInitialisationArchetype extends MonitorArchetype {

	public static final Field<Socket> SOCKET = new Field<>("socket");
	
	public AbstractSocketInitialisationArchetype(String name) {
		super(name);
	}
	
}
