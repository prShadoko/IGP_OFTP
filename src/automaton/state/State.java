package automaton.state;

import automaton.Automaton;
import automaton.event.Archetype;
import automaton.transition.Transition;

public interface State {

	State run(Automaton automaton);
	
	void addTransition(Archetype<?> archetype, Transition transition);
}
