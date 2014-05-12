package oftp.automaton.archetype.monitor.input;

import java.net.Socket;

import automaton.event.Field;
import oftp.automaton.archetype.monitor.SessionConnectionInitiationArchetype;

public class FConnectionRequestArchetype extends SessionConnectionInitiationArchetype {

	public static final String NAME = "F_CONNECT_REQ";
	
	public static final Field<Socket> SOCKET = new Field<>("socket");
	
	public FConnectionRequestArchetype() {
		super(NAME);
	}

}
