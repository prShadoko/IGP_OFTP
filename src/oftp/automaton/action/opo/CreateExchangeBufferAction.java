package oftp.automaton.action.opo;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.FDataRequestArchetype;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;

public class CreateExchangeBufferAction extends OftpAction {

	public CreateExchangeBufferAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {
		Event<?> event = new NetworkEvent(new DataExchangeBufferArchetype(oftp.getBufferSize()));

		byte[] data = inputEvent.getAttribute(FDataRequestArchetype.F_DATA);
		
		event.putAttribute(DataExchangeBufferArchetype.DATA_EXCHANGE_BUFFER_PAYLOAD, data);
		
		oftp.addOutputEvent(event);
	}
}
