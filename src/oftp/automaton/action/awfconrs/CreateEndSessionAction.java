package oftp.automaton.action.awfconrs;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.FReleaseRequestArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;

public class CreateEndSessionAction extends OftpAction {

	private AnswerReason reason;

	public CreateEndSessionAction(OftpAutomaton oftp, AnswerReason reason) {
		super(oftp);
		this.reason = reason;
	}

	public CreateEndSessionAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		if(reason == null) {
			reason = inputEvent.getAttribute(FReleaseRequestArchetype.REASON);
		}

		Event<?> event = new NetworkEvent(new EndSessionArchetype(reason));
		oftp.addOutputEvent(event);
	}
}
