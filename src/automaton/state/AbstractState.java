package automaton.state;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import automaton.Automaton;
import automaton.action.Action;
import automaton.event.Event;
import automaton.transition.Transition;

public class AbstractState implements State {

	private String name;
	
	private Map<String, Transition> transitions = new HashMap<>();
	
	public AbstractState(String name) {
		this.name = name;
	}
	
	@Override
	public void run(Automaton automaton) {
		System.out.println("\n - -- --- " + name + " --- -- - ");
		
		System.out.println("Wait for event");
		Event event = automaton.receiveEvent();
		System.out.println("Event received: " + event.getName());
		//TODO: Manage error
		
		System.out.println("Check transition");
		if(transitions.containsKey(event.getName())) {
			Transition transition = transitions.get(event.getName());
			System.out.println("Transition: " + transition);
			
			Collection<Action> actions = transition.getActions();
			Collection<Event> events = transition.getOutputEvents();
			State nextState = transition.getNextState();
			
			for(Action action : actions) {
				System.out.println("Execute action: " + action.toString());
				action.execute(automaton);
			}
			
			for(Event e : events) {
				System.out.println("Send event: " + e.toString());
				e.send(); // ?
			}
			
			System.out.println("Next state: " + nextState);
			automaton.setState(nextState);
		}
		
	}

	@Override
	public void addTranstion(Event event, Transition transition) {
		transitions.put(event.getName(), transition);
	}

	@Override
	public String toString() {
		return name;
	}
}
