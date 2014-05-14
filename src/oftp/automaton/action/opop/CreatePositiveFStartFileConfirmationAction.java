package oftp.automaton.action.opop;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.PositiveFStartFileConfirmationArchetype;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;

public class CreatePositiveFStartFileConfirmationAction extends OftpAction {

	public CreatePositiveFStartFileConfirmationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> event = new MonitorEvent(new PositiveFStartFileConfirmationArchetype());

		event.putAttribute(PositiveFStartFileConfirmationArchetype.RESTART_POSITION, inputEvent.getAttribute(StartFilePositiveAnswerArchetype.ANSWER_COUNT));

		oftp.addOutputEvent(event);
	}
}
