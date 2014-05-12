package oftp.automaton.predicate.idle;

import automaton.event.Event;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class InitiatorSsidNegotiationPredicate extends OftpPredicate {

	public InitiatorSsidNegotiationPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		CapabilityMode initiatorCapability = oftp.getCapMode();
		CapabilityMode acceptorCapability = inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);

		if(initiatorCapability != CapabilityMode.BOTH && (acceptorCapability == CapabilityMode.BOTH || initiatorCapability != acceptorCapability)) {
			return false;
		}

		boolean initiatorRestart = oftp.isRestartEnabled();
		boolean acceptorRestart = inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION).toBoolean();
		if(!initiatorRestart && acceptorRestart) {
			return false;
		}

		boolean initiatorCompression = oftp.isCompressionEnabled();
		boolean acceptorCompression = inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION).toBoolean();
		if(!initiatorCompression && acceptorCompression) {
			return false;
		}

		int initiatorBufferSize = oftp.getBufferSize();
		int acceptorBufferSize = inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE);
		if(initiatorBufferSize < acceptorBufferSize) {
			return false;
		}

		int initiatorCredit = oftp.getMaximumWindow();
		int acceptorCredit = inputEvent.getAttribute(StartSessionArchetype.CREDIT);
		if(initiatorCredit < acceptorCredit) {
			return false;
		}

		return true;
	}
}
