package oftp.automaton.action;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.EndSessionArchetype;

public class EndSessionAction extends OftpAction {

	private AnswerReason reason;

	public EndSessionAction(OftpAutomaton oftp, AnswerReason reason) {
		super(oftp);
		this.reason = reason;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		NetworkEvent event = new NetworkEvent(new EndSessionArchetype(reason));

		oftp.addOutputEvent(event);
	}
}
