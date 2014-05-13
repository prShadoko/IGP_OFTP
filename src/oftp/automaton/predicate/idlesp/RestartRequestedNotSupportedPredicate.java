package oftp.automaton.predicate.idlesp;

import automaton.event.Event;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.input.FStartFileRequestArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class RestartRequestedNotSupportedPredicate extends OftpPredicate {

	public RestartRequestedNotSupportedPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		int restartPosition = inputEvent.getAttribute(FStartFileRequestArchetype.RESTART_POSITION);
		boolean restartEnabled = oftp.isRestartEnabled();
		CapabilityMode mode = oftp.getMode();

		return restartPosition > 0 && (!restartEnabled || mode == CapabilityMode.RECEIVER_ONLY);
	}
}
