package oftp.automaton.predicate.idleli;

import automaton.event.Event;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartFileArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class InvalidStartFileCommandPredicate extends OftpPredicate {

	public InvalidStartFileCommandPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		boolean restart = oftp.isRestartEnabled();
		int restartPos = inputEvent.getAttribute(StartFileArchetype.RESTART_POSITION);
		
		return (restartPos > 0) && !restart;
	}

}
