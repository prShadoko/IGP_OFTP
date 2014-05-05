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

	private Map<Event, Transition> transitions = new HashMap<>();

	public AbstractState(String name) {
		this.name = name;
	}

	@Override
	public void run(Automaton automaton) {
		System.out.println("\n - -- --- " + name + " --- -- - ");

		System.out.println("Wait for event");
		Event inputEvent = automaton.receiveEvent();
		System.out.println("Event received: " + inputEvent);
		// TODO: Manage error

		System.out.println("Check transition");
		if (transitions.containsKey(inputEvent)) {
			Transition transition = transitions.get(inputEvent);
			System.out.println("Transition: " + transition);

			Collection<Action> actions = transition.getActions();
			State nextState = transition.getNextState();

			for (Action action : actions) {
				System.out.println("Execute action: " + action.toString());
				action.execute(inputEvent);
			}

			System.out.println("Send events");
			automaton.sendOutputEvents();

			System.out.println("Next state: " + nextState);
			automaton.setState(nextState);
		} else {
			System.out.println("No transition found");
		}

	}

	@Override
	public void addTranstion(Event event, Transition transition) {
		transitions.put(event, transition);
	}

	@Override
	public String toString() {
		return name;
	}
}
