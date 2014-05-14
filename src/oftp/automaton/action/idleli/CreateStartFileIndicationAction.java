package oftp.automaton.action.idleli;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FStartFileIndicationArchetype;
import oftp.automaton.archetype.network.StartFileArchetype;

public class CreateStartFileIndicationAction extends OftpAction {

	public CreateStartFileIndicationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		
		oftp.setRestartPosition(inputEvent.getAttribute(StartFileArchetype.RESTART_POSITION));
		
		Event<?> event = new MonitorEvent(new FStartFileIndicationArchetype());

		event.putAttribute(FStartFileIndicationArchetype.DATE_TIME, inputEvent.getAttribute(FStartFileIndicationArchetype.DATE_TIME));
		event.putAttribute(FStartFileIndicationArchetype.DESTINATION, inputEvent.getAttribute(FStartFileIndicationArchetype.DESTINATION));
		event.putAttribute(FStartFileIndicationArchetype.FILE_NAME, inputEvent.getAttribute(FStartFileIndicationArchetype.FILE_NAME));
		event.putAttribute(FStartFileIndicationArchetype.FILE_SIZE, inputEvent.getAttribute(FStartFileIndicationArchetype.FILE_SIZE));
		event.putAttribute(FStartFileIndicationArchetype.ORIGINATOR, inputEvent.getAttribute(FStartFileIndicationArchetype.ORIGINATOR));
		event.putAttribute(FStartFileIndicationArchetype.RECORD_FORMAT, inputEvent.getAttribute(FStartFileIndicationArchetype.RECORD_FORMAT));
		event.putAttribute(FStartFileIndicationArchetype.RECORD_SIZE, inputEvent.getAttribute(FStartFileIndicationArchetype.RECORD_SIZE));
		event.putAttribute(FStartFileIndicationArchetype.RESTART_POSITION, inputEvent.getAttribute(FStartFileIndicationArchetype.RESTART_POSITION));
		
		oftp.addOutputEvent(event);
	}

}
