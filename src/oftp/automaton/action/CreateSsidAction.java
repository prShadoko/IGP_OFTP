package oftp.automaton.action;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.network.StartSessionArchetype;

public class CreateSsidAction extends OftpAction {

	public CreateSsidAction(OftpAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void execute(Event<?> inputEvent) {
		NetworkEvent event = new NetworkEvent(new StartSessionArchetype());
//		event.putAttribute(StartSessionArchetype.LEVEL,                     );
		event.putAttribute(StartSessionArchetype.CODE,                      oftp.getId());
		event.putAttribute(StartSessionArchetype.PASSWORD,                  oftp.getPassword());
		event.putAttribute(StartSessionArchetype.EXCHANGE_BUFFER_SIZE,      oftp.getBufferSize());
		event.putAttribute(StartSessionArchetype.SEND_RECEIVE_CAPABILITY,   oftp.getCapMode());
//		event.putAttribute(StartSessionArchetype.COMPRESSION_INDICATION,    );
//		event.putAttribute(StartSessionArchetype.RESTART_INDICATION,        );
//		event.putAttribute(StartSessionArchetype.SPECIAL_LOGIC_INDICATION,  );
		event.putAttribute(StartSessionArchetype.CREDIT,                    oftp.getCreditSpeaker());
//		event.putAttribute(StartSessionArchetype.RESERVED,                  );
//		event.putAttribute(StartSessionArchetype.USER_DATA,                 );

		oftp.addOutputEvent(event);
	}

}
