package oftp.automaton.predicate.idle;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class SsidNegotiationPredicate extends OftpPredicate {

	public SsidNegotiationPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);
		inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION);
		inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION);
		inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE);
		inputEvent.getAttribute(StartSessionArchetype.CREDIT);

		boolean check = true;//TODO !!!
				
		return check;
	}

}