package oftp.automaton.network;

import automaton.event.network.NetworkArchetype;
import automaton.event.network.NetworkEvent;
import automaton.event.network.NetworkField;
import oftp.automaton.CommandCode;
import oftp.automaton.archetype.network.OftpNetworkArchetype;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	
	public void clear() {
		archetypes.clear();
	}
	
	public NetworkEvent build(String packet) {
		NetworkEvent event = null;
		
		NetworkArchetype archetype = archetypes.get(CommandCode.fromChar(packet.charAt(0)));
		
		if(null != archetype) {
			event = build(packet, archetype);
		}

		return event;
	}

	public NetworkEvent build(String packet, NetworkArchetype archetype) {
		NetworkEvent event = null;

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

				event.putAttribute(field, field.fromString(sub));
				
				pos += field.getLength();
			}
		}

		return event;
	}
}
