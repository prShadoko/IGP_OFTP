package oftp.automaton.action;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionReadyMessageArchetype;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;

public class CreateSsrmAction extends OftpAction {

	public CreateSsrmAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		oftp.addOutputEvent(new NetworkEvent(new StartSessionReadyMessageArchetype()));
	}

}
