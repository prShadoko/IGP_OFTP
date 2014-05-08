package automaton.state;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import automaton.Automaton;
import automaton.action.Action;
import automaton.event.Archetype;
import automaton.event.Event;
import automaton.exception.AutomatonException;
import automaton.transition.Transition;

public class StateImpl implements State {

	private String name;

	private Map<Archetype<?>, Transition> transitions = new HashMap<>();

	public StateImpl(String name) {
		this.name = name;
	}

	@Override
	public State run(Automaton automaton) {
		System.out.println("\n - -- --- " + name + " --- -- - ");
		State nextState = null;

		System.out.println("Wait for event");
		Event<?> inputEvent = automaton.receiveEvent();
		System.out.println("Event received: " + inputEvent);

		try {
			System.out.println("Check transition");
			if (null != inputEvent && transitions.containsKey(inputEvent.getArchetype())) {
				Transition transition = transitions.get(inputEvent.getArchetype());
				System.out.println("Transition: " + transition);

				Collection<Action> actions = transition.getActions();

				System.out.println("Execute actions");
				for (Action action : actions) {
					System.out.println("action: " + action.toString());
					action.execute(inputEvent);
				}

				System.out.println("Send events");
				automaton.sendOutputEvents();

				System.out.println("Next state: " + nextState);
				nextState = transition.getNextState();
			} else {
				System.out.println("No transition found");
				nextState = this;
			}
		} catch (AutomatonException e) {
			e.printStackTrace();
		}

		return nextState;
	}

	@Override
	public void addTranstion(Archetype<?> archetype, Transition transition) {
		transitions.put(archetype, transition);
	}

	@Override
	public String toString() {
		return name;
	}
}
