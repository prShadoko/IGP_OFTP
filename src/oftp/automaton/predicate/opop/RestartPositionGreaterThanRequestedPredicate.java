package oftp.automaton.predicate.opop;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class RestartPositionGreaterThanRequestedPredicate extends OftpPredicate {

	public RestartPositionGreaterThanRequestedPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		int restartPosition = inputEvent.getAttribute(StartFilePositiveAnswerArchetype.ANSWER_COUNT);
		int maximumRestartPosition = oftp.getRestartPosition();

		return restartPosition > maximumRestartPosition;
	}
}
