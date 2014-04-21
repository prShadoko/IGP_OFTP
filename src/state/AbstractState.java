package state;

import java.util.Collection;
import java.util.Map;

import transition.Transition;
import action.Action;
import automaton.Automaton;
import event.Event;

public class AbstractState implements State {

	private Map<String, Transition> transitions;
	
	@Override
	public void run(Automaton automaton) {
		//TODO: Do the event receive logic
		Event event = automaton.receiveEvent();
		//TODO: Manage error
		
		if(transitions.containsKey(event.getName())) {
			Transition transition = transitions.get(event.getName());
			
			Collection<Action> actions = transition.getActions();
			Collection<Event> events = transition.getOutputEvents();
			State nextState = transition.getNextState();
			
			for(Action action : actions) {
				action.execute(automaton);
			}
			
			for(Event e : events) {
				event.send(); // ?
			}
			
			automaton.setState(nextState);
		}
	}

}
