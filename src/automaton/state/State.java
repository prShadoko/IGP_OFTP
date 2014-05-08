package automaton.state;

import automaton.Automaton;
import automaton.event.Archetype;
import automaton.transition.Transition;

public interface State {

	State run(Automaton automaton);
	
	void addTranstion(Archetype<?> archetype, Transition transition);
}
