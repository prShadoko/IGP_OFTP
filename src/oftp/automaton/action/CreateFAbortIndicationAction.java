package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.AbortOrigin;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FAbortRequestArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;

public class CreateFAbortIndicationAction extends OftpAction {

	private AnswerReason reason;
	private AbortOrigin origin;

	public CreateFAbortIndicationAction(OftpAutomaton oftp, AnswerReason reason, AbortOrigin origin) {
		super(oftp);
		this.reason = reason;
		this.origin = origin;
	}

	public CreateFAbortIndicationAction(OftpAutomaton oftp) {
		super(oftp);
		this.reason = null;
		this.origin = null;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> event = new MonitorEvent(new FAbortRequestArchetype());

		if (this.reason != null) {
			event.putAttribute(FAbortRequestArchetype.REASON, this.reason);
			event.putAttribute(FAbortRequestArchetype.ABORT_ORIGIN, this.origin);
		} else {
			event.putAttribute(FAbortRequestArchetype.REASON, inputEvent.getAttribute(EndSessionArchetype.REASON_CODE));
			event.putAttribute(FAbortRequestArchetype.ABORT_ORIGIN, AbortOrigin.DISTANT);
		}
		
		oftp.addOutputEvent(event);
	}

}
