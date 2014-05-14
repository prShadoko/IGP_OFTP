package oftp.service;

import java.util.ArrayList;
import java.util.Collection;

import oftp.automaton.archetype.network.ChangeDirectionArchetype;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;
import oftp.automaton.archetype.network.EndFileArchetype;
import oftp.automaton.archetype.network.EndFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.EndFilePositiveAnswerArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;
import oftp.automaton.archetype.network.EndToEndResponseArchetype;
import oftp.automaton.archetype.network.OftpNetworkArchetype;
import oftp.automaton.archetype.network.ReadyToReceiveArchetype;
import oftp.automaton.archetype.network.SetCreditArchetype;
import oftp.automaton.archetype.network.StartFileArchetype;
import oftp.automaton.archetype.network.StartFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.archetype.network.StartSessionReadyMessageArchetype;

public class OftpNetworkArchetypeProviderService {
	
	public Collection<OftpNetworkArchetype> getArchetype(int dataBufferSize) {
		
		Collection<OftpNetworkArchetype> list = new ArrayList<OftpNetworkArchetype>();
		
		list.add(new StartSessionReadyMessageArchetype());		
		list.add(new StartSessionArchetype());	
		list.add(new StartFilePositiveAnswerArchetype());	
		list.add(new StartFileNegativeAnswerArchetype());	
		list.add(new StartFileArchetype());	
		list.add(new SetCreditArchetype());	
		list.add(new ReadyToReceiveArchetype());	
		list.add(new EndToEndResponseArchetype());	
		list.add(new EndSessionArchetype());	
		list.add(new EndFileNegativeAnswerArchetype());	
		list.add(new EndFilePositiveAnswerArchetype());	
		list.add(new EndFileArchetype());	
		list.add(new DataExchangeBufferArchetype(dataBufferSize));	
		list.add(new ChangeDirectionArchetype());
		
		return list;

	}

}
