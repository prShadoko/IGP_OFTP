package oftp.automaton.action;

import oftp.automaton.OFTPAutomaton;
import oftp.automaton.event.network.archetype.StartSessionReadyMessageArchetype;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;

public class SendSSRMAction extends OFTPAction {

	public SendSSRMAction(OFTPAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		automaton.addOutputEvent(new NetworkEvent(new StartSessionReadyMessageArchetype()));
	}

}
