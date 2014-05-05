package oftp.automaton.event.monitor;

import java.net.Socket;

public class AbstractSocketInitialisationEvent extends MonitorEvent {

	public static final String SOCKET = "socket";
	
	public AbstractSocketInitialisationEvent(String name) {
		super(name);
		
	}

	public void setSocket(Socket socket) {
		setAttribute(SOCKET, socket);
	}
	
}
