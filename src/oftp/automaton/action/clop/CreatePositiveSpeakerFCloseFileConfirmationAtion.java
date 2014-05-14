package oftp.automaton.action.clop;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.PositiveFCloseFileConfirmationArchetype;

public class CreatePositiveSpeakerFCloseFileConfirmationAtion extends OftpAction {

	public CreatePositiveSpeakerFCloseFileConfirmationAtion(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new MonitorEvent(new PositiveFCloseFileConfirmationArchetype());

		event.putAttribute(PositiveFCloseFileConfirmationArchetype.SPEAKER, true);

		oftp.addOutputEvent(event);
	}
}
