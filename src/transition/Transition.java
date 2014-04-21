package transition;

import java.util.Collection;

import state.State;
import action.Action;
import automaton.Automaton;
import event.Event;

public interface Transition {

	Collection<Action> getActions(Automaton automaton);

	Collection<Event> getOutputEvents(Automaton automaton);
	
	State getNextState(Automaton automaton);
}
