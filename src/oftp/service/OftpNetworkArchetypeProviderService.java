package oftp.service;

import java.util.ArrayList;
import java.util.Collection;

import oftp.automaton.archetype.network.OftpNetworkArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.archetype.network.StartSessionReadyMessageArchetype;

public class OftpNetworkArchetypeProviderService {
	
	public Collection<OftpNetworkArchetype> getArchetype() {
		
		Collection<OftpNetworkArchetype> list = new ArrayList<OftpNetworkArchetype>();
		
		list.add(new StartSessionReadyMessageArchetype());		
		list.add(new StartSessionArchetype());
		
		return list;

	}

}
