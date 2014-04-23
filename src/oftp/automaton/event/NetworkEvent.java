package oftp.automaton.event;

import automaton.Automaton;
import automaton.event.Event;

public abstract class NetworkEvent implements Event {
	
	public abstract char[] toBytes();
	
	@Override
	public void send() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
