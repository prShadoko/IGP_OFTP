package oftp.automaton.action.opo;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionException;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;

public class CreateExchangeBufferAction extends OftpAction {

	public CreateExchangeBufferAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionException {
		Event<?> event = new NetworkEvent(new DataExchangeBufferArchetype());

//		event.putAttribute(DataExchangeBufferArchetype.DATA_EXCHANGE_BUFFER_PAYLOAD, ???);//TODO: construire le buffer
	}
}
