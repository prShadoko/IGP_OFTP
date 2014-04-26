package oftp.automaton.event;

import automaton.event.AbstractEvent;

public abstract class NetworkEvent extends AbstractEvent {
	
	public NetworkEvent(String name) {
		super(name);
	}

	public abstract char[] toBytes();
	
	@Override
	public void send() {
		// TODO Auto-generated method stub
		
	}

}
