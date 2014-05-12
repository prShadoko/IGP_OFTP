package oftp.automaton.predicate;

import automaton.event.Event;
import oftp.automaton.CapabilityMode;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.YesNo;
import oftp.automaton.archetype.network.StartSessionArchetype;

public class SsidNegotiationPredicate extends OftpPredicate {

	public SsidNegotiationPredicate(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public boolean check(Event<?> inputEvent) {

		CapabilityMode initiatorCapability = oftp.getCapMode();
		CapabilityMode acceptorCapability = inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY);

		if(initiatorCapability != CapabilityMode.BOTH && (acceptorCapability == CapabilityMode.BOTH || initiatorCapability != acceptorCapability)) {
			return false;
		}

		YesNo initiatorRestart = oftp.getRestart();
		YesNo acceptorRestart = inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION);
		if(initiatorRestart == YesNo.NO && acceptorRestart == YesNo.YES) {
			return false;
		}

		YesNo initiatorCompression = oftp.getCompression();
		YesNo acceptorCompression = inputEvent.getAttribute(StartSessionArchetype.COMPRESSION_INDICATION);
		if(initiatorCompression == YesNo.NO && acceptorCompression == YesNo.YES) {
			return false;
		}

		int initiatorBufferSize = oftp.getBufferSize();
		int acceptorBufferSize = inputEvent.getAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE);
		if(initiatorBufferSize < acceptorBufferSize || acceptorBufferSize < 128) {
			return false;
		}

		int initiatorCredit = oftp.getCredit
		int acceptorCredit = inputEvent.getAttribute(StartSessionArchetype.CREDIT);

		return true;
	}
}
