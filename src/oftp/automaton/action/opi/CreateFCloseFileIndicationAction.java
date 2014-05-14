package oftp.automaton.action.opi;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FCloseFileIndicationArchetype;
import oftp.automaton.archetype.network.EndFileArchetype;

public class CreateFCloseFileIndicationAction extends OftpAction {

	public CreateFCloseFileIndicationAction(OftpAutomaton oftp) {
		super(oftp);

	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> fCloseFile = new MonitorEvent(new FCloseFileIndicationArchetype());
		
		fCloseFile.putAttribute(FCloseFileIndicationArchetype.RECORD_COUNT, inputEvent.getAttribute(EndFileArchetype.RECORD_COUNT));
		fCloseFile.putAttribute(FCloseFileIndicationArchetype.UNIT_COUNT, inputEvent.getAttribute(EndFileArchetype.UNIT_COUNT));
		
		oftp.addOutputEvent(fCloseFile);
	}

}
