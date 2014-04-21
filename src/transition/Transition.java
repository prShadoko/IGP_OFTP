package transition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import predicate.Predicate;
import state.State;
import action.Action;
import event.Event;

public class Transition {

	Predicate predicate;

	Map<Boolean, Collection<Action>> actions;
	Map<Boolean, Collection<Event>> outputEvents;
	Map<Boolean, State> nextStates;

	public Transition() {
		predicate = null;

		actions = new HashMap<>();
		actions.put(true, new ArrayList<Action>());
		actions.put(false, new ArrayList<Action>());

		outputEvents = new HashMap<>();
		outputEvents.put(true, new ArrayList<Event>());
		outputEvents.put(false, new ArrayList<Event>());
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	@SuppressWarnings("unchecked")
	public Collection<Action> getActions() {
		return (Collection<Action>) get(actions);
	}

	@SuppressWarnings("unchecked")
	public Collection<Event> getOutputEvents() {
		return (Collection<Event>) get(outputEvents);
	}

	public State getNextState() {
		return (State) get(nextStates);
	}

	private Object get(Map<Boolean, ?> predicatedMap) {
		Object result = new ArrayList<>();

		if (null != predicate) {
			result = predicatedMap.get(predicate.check());
		} else {
			result = predicatedMap.get(true);
		}

		return result;
	}
}
