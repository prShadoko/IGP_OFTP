package oftp.automaton.event.monitor;

public class FConnectRequestEvent extends AbstractSocketInitialisationEvent {

	public static final String NAME = "F_CONNECT_REQ";
	
	public FConnectRequestEvent() {
		super(NAME);
	}

}
