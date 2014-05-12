package oftp.automaton.predicate.idle;

import oftp.automaton.CapabilityInit;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.predicate.OftpPredicate;
import automaton.event.Event;

public class IsInitiatorPredicate extends OftpPredicate {

	public IsInitiatorPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		CapabilityInit capInit = oftp.getCapInit();
		boolean check = capInit.equals(CapabilityInit.INITIATOR);
				
		return check;
	}

}
