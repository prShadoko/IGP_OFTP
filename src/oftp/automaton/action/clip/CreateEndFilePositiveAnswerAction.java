package oftp.automaton.action.clip;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.YesNo;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.PositiveFCloseFileResponseArchetype;
import oftp.automaton.archetype.network.EndFilePositiveAnswerArchetype;

public class CreateEndFilePositiveAnswerAction extends OftpAction {

	public CreateEndFilePositiveAnswerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new NetworkEvent(new EndFilePositiveAnswerArchetype());

		event.putAttribute(EndFilePositiveAnswerArchetype.CHANGE_DIRECTION_INDICATOR, YesNo.fromBoolean(inputEvent.getAttribute(PositiveFCloseFileResponseArchetype.SPEAKER)));

		oftp.addOutputEvent(event);
	}
}
