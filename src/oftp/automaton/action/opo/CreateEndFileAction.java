package oftp.automaton.action.opo;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.FCloseFileRequestArchetype;
import oftp.automaton.archetype.network.EndFileArchetype;


public class CreateEndFileAction extends OftpAction {

	public CreateEndFileAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new NetworkEvent(new EndFileArchetype());

		event.putAttribute(EndFileArchetype.RECORD_COUNT, inputEvent.getAttribute(FCloseFileRequestArchetype.RECORD_COUNT));
		event.putAttribute(EndFileArchetype.UNIT_COUNT, inputEvent.getAttribute(FCloseFileRequestArchetype.UNIT_COUNT));

		oftp.addOutputEvent(event);
	}
}
