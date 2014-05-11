package oftp.automaton.predicate;

import oftp.automaton.CapabilityInit;
import oftp.automaton.OftpAutomaton;
import automaton.event.Event;

public class IsInitiatorPredicate extends OftpPredicate {

	public IsInitiatorPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		CapabilityInit capInit = oftp.getCapInit();
		boolean check = capInit.equals(CapabilityInit.INITIATOR) || capInit.equals(CapabilityInit.BOTH);
				
		return check;
	}

}
