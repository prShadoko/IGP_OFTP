package state;

import java.util.Collection;

import transition.Transition;
import action.Action;
import automaton.Automaton;
import event.Event;

public class AbstractState implements State {

	private Collection<Transition> transitions;
	
	@Override
	public void run(Automaton automaton) {
		//TODO: Do the event receive logic
		//TODO: Manage error
		
		for(Transition transition : transitions) {
			Collection<Action> actions = transition.getActions(automaton);
			Collection<Event> events = transition.getOutputEvents(automaton);
			State nextState = transition.getNextState(automaton);
			
			for(Action action : actions) {
				action.execute(automaton);
			}
			
			for(Event event : events) {
				automaton.sendEvent(event); // ?
			}
			
			automaton.setState(nextState);
		}
	}

}
