package oftp.automaton.action.iwfssid;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FConnectionConfirmationArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;

public class CreateFConnectionConfirmationAction extends OftpAction {

	public CreateFConnectionConfirmationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> fconncf = new MonitorEvent(new FConnectionConfirmationArchetype());

		fconncf.putAttribute(FConnectionConfirmationArchetype.ID,
				inputEvent.getAttribute(StartSessionArchetype.CODE));
		fconncf.putAttribute(FConnectionConfirmationArchetype.PASSWORD,
				inputEvent.getAttribute(StartSessionArchetype.PASSWORD));
		fconncf.putAttribute(FConnectionConfirmationArchetype.MODE,
				inputEvent.getAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY));
		fconncf.putAttribute(FConnectionConfirmationArchetype.RESTART,
				inputEvent.getAttribute(StartSessionArchetype.RESTART_INDICATION).toBoolean());
		
		oftp.addOutputEvent(fconncf);
	}

}
