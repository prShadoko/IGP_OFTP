package oftp.automaton.action.opop;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.NegativeFStartFileConfirmationArchetype;
import oftp.automaton.archetype.network.StartFileNegativeAnswerArchetype;

public class CreateNegativeFStartFileConfirmationAction extends OftpAction {

	public CreateNegativeFStartFileConfirmationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> event = new MonitorEvent(new NegativeFStartFileConfirmationArchetype());

		event.putAttribute(NegativeFStartFileConfirmationArchetype.CAUSE,       inputEvent.getAttribute(StartFileNegativeAnswerArchetype.ANSWER_REASON));
		event.putAttribute(NegativeFStartFileConfirmationArchetype.RETRY_LATER, inputEvent.getAttribute(StartFileNegativeAnswerArchetype.RETRY_INDICATOR));

		oftp.addOutputEvent(event);
	}
}
