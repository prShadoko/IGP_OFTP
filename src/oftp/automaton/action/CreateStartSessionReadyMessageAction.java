package oftp.automaton.action;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionReadyMessageArchetype;

public class CreateStartSessionReadyMessageAction extends OftpAction {

	public CreateStartSessionReadyMessageAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		oftp.addOutputEvent(new NetworkEvent(new StartSessionReadyMessageArchetype()));
	}

}
