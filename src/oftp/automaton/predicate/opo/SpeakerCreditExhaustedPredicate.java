package oftp.automaton.predicate.opo;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.predicate.OftpPredicate;

public class SpeakerCreditExhaustedPredicate extends OftpPredicate {

	public SpeakerCreditExhaustedPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		return (oftp.getCreditSpeaker() - 1) == 0;
	}
}
