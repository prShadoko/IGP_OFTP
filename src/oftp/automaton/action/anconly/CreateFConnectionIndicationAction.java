package oftp.automaton.action.anconly;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FConnectionIndicationArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;

public class CreateFConnectionIndicationAction extends OftpAction {

	public CreateFConnectionIndicationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new MonitorEvent(new FConnectionIndicationArchetype());
//		event.putAttribute(FConnectionIndicationArchetype.CALLED_ADDRESS,
//				inputEvent.getAttribute(StartSessionArchetype.));
//		event.putAttribute(FConnectionIndicationArchetype.CALLING_ADDRESS,
//				inputEvent.getAttribute(StartSessionArchetype.));
		
		event.putAttribute(FConnectionIndicationArchetype.ID,
				inputEvent.getAttribute(StartSessionArchetype.CODE));
		event.putAttribute(FConnectionIndicationArchetype.PASSWORD,
				inputEvent.getAttribute(StartSessionArchetype.PASSWORD));
		event.putAttribute(FConnectionIndicationArchetype.MODE,
				inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY));
		event.putAttribute(FConnectionIndicationArchetype.RESTART,
				inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION).toBoolean());
		
		oftp.addOutputEvent(event);
		
		oftp.setSsid(inputEvent);
	}

}
