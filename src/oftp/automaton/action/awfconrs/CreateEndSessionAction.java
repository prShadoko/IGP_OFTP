package oftp.automaton.action.awfconrs;

import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.network.EndSessionArchetype;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionExeption;

public class CreateEndSessionAction extends OftpAction {

	private AnswerReason reason;

	public CreateEndSessionAction(OftpAutomaton oftp, AnswerReason reason) {
		super(oftp);
		this.reason = reason;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> event = new NetworkEvent(new EndSessionArchetype(reason));
		oftp.addOutputEvent(event);
	}

}
