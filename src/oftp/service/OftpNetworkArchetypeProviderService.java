package oftp.service;

import oftp.automaton.archetype.network.*;

import java.util.ArrayList;
import java.util.Collection;

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
