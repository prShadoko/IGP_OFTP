package automaton.event.network;

import automaton.event.AbstractEvent;
import automaton.tools.NetworkTools;

public class NetworkEvent extends AbstractEvent {
	
	public static final String TO_BYTES = "toBytes";
	
	private NetworkArchetype archetype;
	
	public NetworkEvent(NetworkArchetype archetype) {
		super(archetype.getName());
		this.archetype = archetype;
		init();
	}
	
	private void init() {
		for(NetworkField<?> field : archetype.getFields()) {
			if(field.hasExpectedValue()) {
				this.setAttribute(field.getName(), field.getExpectedValue());
			}
		}
	}

	@Override
	public Object getAttribute(String key) {
		
		if(TO_BYTES.equals(key)) {
			setAttribute(key, this.toBytes());
		}
		
		return super.getAttribute(key);
	}
	
	public byte[] toBytes() {
		StringBuilder bytes = new StringBuilder();
		
		for(NetworkField<?> field : archetype.getFields()) {
			Object attribute = getAttribute(field.getName());
			String attributeStr = "";
			if(null != attribute) {
				attributeStr = attribute.toString();
			}
			bytes.append(NetworkTools.formatString(attributeStr, field.getLength(), ' '));
		}
		
		return bytes.toString().getBytes();
	}

}
