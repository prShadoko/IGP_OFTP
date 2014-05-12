package oftp.automaton.predicate.anconly;

import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.OftpPredicate;
import automaton.event.Event;


public class IncompatibleSsidAndCapModePredicate extends OftpPredicate {

	public IncompatibleSsidAndCapModePredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		CapabilityMode capMode = oftp.getCapMode();
		CapabilityMode mode = inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);
		
		boolean result = true;
		switch (capMode) {
		case BOTH:
			result = false;
			break;

		default:
			result = capMode != mode;
			break;
		}
		
		return result;
	}

}
