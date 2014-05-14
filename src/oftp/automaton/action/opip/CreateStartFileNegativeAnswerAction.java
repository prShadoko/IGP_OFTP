package oftp.automaton.action.opip;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.YesNo;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.NegativeFStartFileResponseArchetype;
import oftp.automaton.archetype.network.StartFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;

public class CreateStartFileNegativeAnswerAction extends OftpAction {

	public CreateStartFileNegativeAnswerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> sfna = new NetworkEvent(new StartFilePositiveAnswerArchetype());

		sfna.putAttribute(StartFileNegativeAnswerArchetype.ANSWER_REASON, inputEvent.getAttribute(NegativeFStartFileResponseArchetype.CAUSE));
		sfna.putAttribute(StartFileNegativeAnswerArchetype.RETRY_INDICATOR, YesNo.fromBoolean(inputEvent.getAttribute(NegativeFStartFileResponseArchetype.RETRY_LATER)));

		oftp.addOutputEvent(sfna);
	}

}
