package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.AbortOrigin;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FAbortRequestArchetype;

public class CreateFAbortIndicationAction extends OftpAction {

	private AnswerReason reason;
	private AbortOrigin origin;

	public CreateFAbortIndicationAction(OftpAutomaton oftp, AnswerReason reason, AbortOrigin origin) {
		super(oftp);
		this.reason = reason;
		this.origin = origin;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		
		Event<?> event = new MonitorEvent(new FAbortRequestArchetype());
		event.putAttribute(FAbortRequestArchetype.REASON, this.reason);
		event.putAttribute(FAbortRequestArchetype.ABORT_ORIGIN, this.origin);
		
		oftp.addOutputEvent(event);
	}

}
