package oftp.automaton.action.idleli;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import automaton.tools.NetworkTools;
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

		event.putAttribute(FStartFileIndicationArchetype.DATE_TIME, inputEvent.getAttribute(StartFileArchetype.VIRTUAL_FILE_TIME_STAMP));
		event.putAttribute(FStartFileIndicationArchetype.DESTINATION, NetworkTools.removeLeftPad(inputEvent.getAttribute(StartFileArchetype.DESTINATION), ' '));
		event.putAttribute(FStartFileIndicationArchetype.FILE_NAME, NetworkTools.removeLeftPad(inputEvent.getAttribute(StartFileArchetype.VIRTUAL_FILE_DATA_SET_NAME), ' '));
		event.putAttribute(FStartFileIndicationArchetype.FILE_SIZE, inputEvent.getAttribute(StartFileArchetype.FILE_SIZE));
		event.putAttribute(FStartFileIndicationArchetype.ORIGINATOR, inputEvent.getAttribute(StartFileArchetype.ORIGINATOR));
		event.putAttribute(FStartFileIndicationArchetype.RECORD_FORMAT, inputEvent.getAttribute(StartFileArchetype.FILE_FORMAT));
		event.putAttribute(FStartFileIndicationArchetype.RECORD_SIZE, inputEvent.getAttribute(StartFileArchetype.FILE_SIZE));
		event.putAttribute(FStartFileIndicationArchetype.RESTART_POSITION, inputEvent.getAttribute(StartFileArchetype.RESTART_POSITION));
		
		oftp.addOutputEvent(event);
	}

}
