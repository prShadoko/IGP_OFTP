package oftp.automaton.network;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import oftp.automaton.CommandCode;
import oftp.automaton.archetype.network.OftpNetworkArchetype;
import automaton.event.network.NetworkArchetype;
import automaton.event.network.NetworkEvent;
import automaton.event.network.NetworkField;

public class OftpNetworkEventFactory {

	private Map<CommandCode, NetworkArchetype> archetypes = new HashMap<>();
	
	public OftpNetworkEventFactory() {
		
	}

	public void addArchetype(OftpNetworkArchetype archetype) {
		archetypes.put(archetype.getCommandCode().getExpectedValue(), archetype);
	}
	
	public void addArchetypes(Collection<OftpNetworkArchetype> archetypes) {
		for(OftpNetworkArchetype archetype : archetypes) {
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

				event.putAttribute(field, sub);
				
				pos += field.getLength();
			}
		}
		
		return event;
	}
}
