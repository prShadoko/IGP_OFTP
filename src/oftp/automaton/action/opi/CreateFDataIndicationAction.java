package oftp.automaton.action.opi;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.output.FDataIndicationArchetype;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;

public class CreateFDataIndicationAction extends OftpAction {

	public CreateFDataIndicationAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> fDataInd = new MonitorEvent(new FDataIndicationArchetype());
		
		fDataInd.putAttribute(FDataIndicationArchetype.DATA, inputEvent.getAttribute(DataExchangeBufferArchetype.DATA_EXCHANGE_BUFFER_PAYLOAD));
		
		oftp.addOutputEvent(fDataInd);
	}

}
