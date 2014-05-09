package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.event.network.archetype.StartSessionReadyMessageArchetype;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;

public class SendSSRMAction extends OftpAction {

	public SendSSRMAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		oftp.addOutputEvent(new NetworkEvent(new StartSessionReadyMessageArchetype()));
	}

}
