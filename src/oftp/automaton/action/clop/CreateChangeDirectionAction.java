package oftp.automaton.action.clop;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.network.ChangeDirectionArchetype;

public class CreateChangeDirectionAction extends OftpAction {

	public CreateChangeDirectionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new NetworkEvent(new ChangeDirectionArchetype());

		oftp.addOutputEvent(event);
	}
}
