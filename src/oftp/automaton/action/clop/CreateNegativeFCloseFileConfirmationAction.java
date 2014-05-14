package oftp.automaton.action.clop;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.NegativeFCloseFileConfirmationArchetype;
import oftp.automaton.archetype.network.EndFileNegativeAnswerArchetype;

public class CreateNegativeFCloseFileConfirmationAction extends OftpAction {

	public CreateNegativeFCloseFileConfirmationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new MonitorEvent(new NegativeFCloseFileConfirmationArchetype());

		event.putAttribute(NegativeFCloseFileConfirmationArchetype.ANSWER_REASON, inputEvent.getAttribute(EndFileNegativeAnswerArchetype.ANSWER_REASON));
	}
}
