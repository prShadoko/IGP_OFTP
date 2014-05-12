package oftp.automaton.predicate.idle;

import automaton.event.Event;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.OftpPredicate;

public class AcceptorSsidNegotiationPredicate extends OftpPredicate {

	public AcceptorSsidNegotiationPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {
		inputEvent = oftp.getSsid();
		CapabilityMode acceptorCapability = oftp.getCapMode();
		CapabilityMode initiatorCapability = inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);

		if(initiatorCapability != CapabilityMode.BOTH && (acceptorCapability == CapabilityMode.BOTH || initiatorCapability != acceptorCapability)) {
			return false;
		}

		boolean acceptorRestart = oftp.isRestartEnabled();
		boolean initiatorRestart = inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION).toBoolean();
		if(!initiatorRestart && acceptorRestart) {
			return false;
		}

		boolean acceptorCompression = oftp.isCompressionEnabled();
		boolean initiatorCompression = inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION).toBoolean();
		if(!initiatorCompression && acceptorCompression) {
			return false;
		}

		int acceptorBufferSize = oftp.getBufferSize();
		int initiatorBufferSize = inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE);
		if(initiatorBufferSize < acceptorBufferSize) {
			return false;
		}

		int acceptorCredit = oftp.getMaximumWindow();
		int initiatorCredit = inputEvent.getAttribute(StartSessionArchetype.CREDIT);
		if(initiatorCredit < acceptorCredit) {
			return false;
		}

		return true;
	}

}
