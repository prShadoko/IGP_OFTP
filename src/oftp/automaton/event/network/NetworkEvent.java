package oftp.automaton.event.network;

import automaton.event.AbstractEvent;

public abstract class NetworkEvent extends AbstractEvent {
	
	public static final String TO_BYTES = "toBytes";
	
	public NetworkEvent(String name) {
		super(name);
	}

	@Override
	public Object getAttribute(String key) {
		
		if(TO_BYTES.equals(key)) {
			setAttribute(key, this.toBytes());
		}
		
		return super.getAttribute(key);
	}
	
	public abstract byte[] toBytes();

}
