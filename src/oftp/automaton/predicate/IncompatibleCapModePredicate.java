package oftp.automaton.predicate;

import automaton.event.Event;
import automaton.event.network.NetworkField;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.event.network.archetype.StartSessionArchetype;


public class IncompatibleCapModePredicate extends OftpPredicate {

	public IncompatibleCapModePredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		char capMode = inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);
		
//		if(capMode != )
		
		return false;
	}

}
