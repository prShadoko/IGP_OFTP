package automaton;

import event.Event;
import state.State;

public interface Automaton {

	void run();
	
	void setState(State state);
	
	Event receiveEvent();
}
