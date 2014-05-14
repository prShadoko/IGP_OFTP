package oftp.automaton.predicate.clip;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.input.PositiveFCloseFileResponseArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class ChangeDirectionRequestedPredicate extends OftpPredicate {

	public ChangeDirectionRequestedPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		boolean changeDirectionRequested = inputEvent.getAttribute(PositiveFCloseFileResponseArchetype.SPEAKER);
		return changeDirectionRequested;
	}
}
