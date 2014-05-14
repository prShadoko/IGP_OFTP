package oftp.automaton.action.opip;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.PositiveFStartFileResponseArchetype;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;

public class CreateStartFilePositiveAnswerAction extends OftpAction {

	public CreateStartFilePositiveAnswerAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> sfpa = new NetworkEvent(new StartFilePositiveAnswerArchetype());
		
		sfpa.putAttribute(StartFilePositiveAnswerArchetype.ANSWER_COUNT, inputEvent.getAttribute(PositiveFStartFileResponseArchetype.RESTART_POSITION));

		oftp.addOutputEvent(sfpa);
	}

}
