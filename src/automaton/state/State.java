package automaton.state;

import automaton.Automaton;
import automaton.event.Event;
import automaton.transition.Transition;

public interface State {

	void run(Automaton automaton);
	
	void addTranstion(Event event, Transition transition);
}
