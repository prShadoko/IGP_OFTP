package oftp.service;

import java.util.ArrayList;
import java.util.Collection;

import oftp.automaton.event.network.archetype.OFTPNetworkArchetype;
import oftp.automaton.event.network.archetype.StartSessionIDArchetype;
import oftp.automaton.event.network.archetype.StartSessionReadyMessageArchetype;

public class OFTPNetworkArchetypeProviderService {
	
	public Collection<OFTPNetworkArchetype> getArchetype() {
		
		Collection<OFTPNetworkArchetype> list = new ArrayList<OFTPNetworkArchetype>();
		
		list.add(new StartSessionReadyMessageArchetype());		
		list.add(new StartSessionIDArchetype());
		
		return list;

	}

}
