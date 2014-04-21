package event;

import automaton.Automaton;

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
