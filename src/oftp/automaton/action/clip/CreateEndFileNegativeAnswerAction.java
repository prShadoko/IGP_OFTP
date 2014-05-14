package oftp.automaton.action.clip;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.NegativeFCloseFileResponseArchetype;
import oftp.automaton.archetype.network.EndFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.EndFilePositiveAnswerArchetype;

public class CreateEndFileNegativeAnswerAction extends OftpAction {

	public CreateEndFileNegativeAnswerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new NetworkEvent(new EndFilePositiveAnswerArchetype());

		event.putAttribute(EndFileNegativeAnswerArchetype.ANSWER_REASON, NegativeFCloseFileResponseArchetype.ANSWER_REASON);

		oftp.addOutputEvent(event);
	}
}
