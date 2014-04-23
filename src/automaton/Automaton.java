package automaton;

import automaton.event.Event;
import automaton.state.State;

public interface Automaton extends Runnable {
	
	void setState(State state);
	
	Event receiveEvent();
}
