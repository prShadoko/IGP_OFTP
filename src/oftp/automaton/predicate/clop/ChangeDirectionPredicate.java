package oftp.automaton.predicate.clop;

import automaton.event.Event;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.EndFilePositiveAnswerArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class ChangeDirectionPredicate extends OftpPredicate {

	public ChangeDirectionPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		boolean changeDirectionRequest = inputEvent.getAttribute(EndFilePositiveAnswerArchetype.CHANGE_DIRECTION_INDICATOR).toBoolean();
		CapabilityMode mode = oftp.getMode();

		return changeDirectionRequest && (mode == CapabilityMode.BOTH);
	}
}
