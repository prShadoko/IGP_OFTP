package oftp.service;

import java.util.ArrayList;
import java.util.Collection;

import oftp.automaton.event.network.archetype.OftpNetworkArchetype;
import oftp.automaton.event.network.archetype.StartSessionArchetype;
import oftp.automaton.event.network.archetype.StartSessionReadyMessageArchetype;

public class OftpNetworkArchetypeProviderService {
	
	public Collection<OftpNetworkArchetype> getArchetype() {
		
		Collection<OftpNetworkArchetype> list = new ArrayList<OftpNetworkArchetype>();
		
		list.add(new StartSessionReadyMessageArchetype());		
		list.add(new StartSessionArchetype());
		
		return list;

	}

}
