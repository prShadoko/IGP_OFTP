package automaton;

import state.State;

public interface Automaton {

	void run();
	
	void setState(State state);
}
