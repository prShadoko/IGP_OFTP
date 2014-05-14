package oftp.automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.AbortOrigin;
import oftp.automaton.AnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FAbortIndicationArchetype;

public class UserErrorAction extends OftpAction {
	
	private AnswerReason reason;
	private AbortOrigin origin;

	public UserErrorAction(OftpAutomaton automaton, AnswerReason reason, AbortOrigin origin) {
		super(automaton);
		this.reason = reason;
		this.origin = origin;
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		System.out.println("User Error !");
		System.out.println("Event " + inputEvent + " not expected.");
		oftp.closeNetworkLayer();
		
		Event<?> event = new MonitorEvent(new FAbortIndicationArchetype());
		event.putAttribute(FAbortIndicationArchetype.REASON, reason);
		event.putAttribute(FAbortIndicationArchetype.ABORT_ORIGIN, origin);
		oftp.addOutputEvent(event);
	}

}
