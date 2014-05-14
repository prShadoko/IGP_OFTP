package oftp.automaton.action.opop;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.PositiveFStartFileConfirmationArchetype;

public class CreateFStartFileConfirmationAction extends OftpAction {

	public CreateFStartFileConfirmationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> fStartFileCf = new MonitorEvent(new PositiveFStartFileConfirmationArchetype());
		
		fStartFileCf.putAttribute(PositiveFStartFileConfirmationArchetype.RESTART_POSITION, 0);
		
		oftp.addOutputEvent(fStartFileCf);
	}

}
