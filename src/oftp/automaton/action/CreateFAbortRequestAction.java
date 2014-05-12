package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.AbortOrigin;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FAbortRequestArchetype;
import oftp.automaton.archetype.monitor.output.FAbortIndicationArchetype;

public class CreateFAbortRequestAction extends OftpAction {
	
	private AnswerReason reason;
	private AbortOrigin origin;
	
	public CreateFAbortRequestAction(OftpAutomaton oftp, AnswerReason reason, AbortOrigin origin) {
		super(oftp);
		this.reason = reason;
		this.origin = origin;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		
		Event<?> event = new MonitorEvent(new FAbortIndicationArchetype());
		event.putAttribute(FAbortIndicationArchetype.REASON, this.reason);
		event.putAttribute(FAbortIndicationArchetype.ABORT_ORIGIN, this.origin);
		
		oftp.addOutputEvent(event);
	}

}
