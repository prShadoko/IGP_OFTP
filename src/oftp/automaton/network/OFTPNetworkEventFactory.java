package oftp.automaton.network;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import oftp.automaton.event.network.archetype.OFTPNetworkArchetype;
import automaton.event.network.NetworkArchetype;
import automaton.event.network.NetworkEvent;
import automaton.event.network.NetworkField;

public class OFTPNetworkEventFactory {

	private Map<Character, NetworkArchetype> archetypes = new HashMap<>();
	
	public OFTPNetworkEventFactory() {
		
	}

	public void addArchetype(OFTPNetworkArchetype archetype) {
		archetypes.put(archetype.getCommandCode().getExpectedValue(), archetype);
	}
	
	public void addArchetypes(Collection<OFTPNetworkArchetype> archetypes) {
		for(OFTPNetworkArchetype archetype : archetypes) {
			addArchetype(archetype);
		}
	}
	
	public NetworkEvent build(String packet) {
		NetworkEvent event = null;
		
		NetworkArchetype archetype = archetypes.get(packet.charAt(0));
		
		if(null != archetype) {
			event = build(packet, archetype);
		}

		return event;
	}

	public NetworkEvent build(String packet, NetworkArchetype archetype) {
		NetworkEvent event = null;
		System.out.println("archetype: "+ archetype.getName());
		
		if(packet.length() == archetype.getLength()) {
			event = new NetworkEvent(archetype);
			int pos = 0;
			
			for(NetworkField<?> field : archetype.getFields()) {
				String sub = packet.substring(pos,pos + field.getLength());
				
				if(field.hasExpectedValue()){
					if(!field.getExpectedValue().toString().equals(sub)) {
						return null;
					}
				}

				event.setAttribute(field.getName(), sub);
				
				pos += field.getLength();
			}
		}
		
		return event;
	}
}
