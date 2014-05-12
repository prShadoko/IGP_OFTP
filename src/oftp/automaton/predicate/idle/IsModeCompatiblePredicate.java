package oftp.automaton.predicate.idle;

import automaton.event.Event;
import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class IsModeCompatiblePredicate extends OftpPredicate {

	public IsModeCompatiblePredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		if(!inputEvent.is(new FConnectionRequestArchetype())) {
			return true;
		}
		boolean noResourcesAvailable = false;
		boolean responder = oftp.getCapInit().equals(CapabilityInit.RESPONDER);
		boolean senderOnly = oftp.getCapMode().equals(CapabilityMode.SENDER_ONLY);
		boolean receiverOnlyRq = inputEvent.getAttribute(FConnectionRequestArchetype.MODE).equals(CapabilityMode.RECEIVER_ONLY);
		boolean receiverOnly = oftp.getCapMode().equals(CapabilityMode.RECEIVER_ONLY);
		boolean senderOnlyRq = inputEvent.getAttribute(FConnectionRequestArchetype.MODE).equals(CapabilityMode.SENDER_ONLY);
		
		return (noResourcesAvailable || responder || (senderOnly && receiverOnlyRq) || (receiverOnly && senderOnlyRq));
	}

}
