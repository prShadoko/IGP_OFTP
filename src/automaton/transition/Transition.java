package automaton.transition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import automaton.action.Action;
import automaton.event.Event;
import automaton.predicate.Predicate;
import automaton.state.State;

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

		nextStates = new HashMap<>();
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	public void setNextState(State nextState) {
		setNextState(true, nextState);
	}

	public void setNextState(Boolean predicate, State nextState) {
		nextStates.put(predicate, nextState);
	}

	public void addAction(Action action) {
		addAction(true, action);
	}

	public void addAction(Boolean predicate, Action action) {
		actions.get(predicate).add(action);
	}

	public void addOutputEvent(Event event) {
		addOutputEvent(true, event);
	}

	public void addOutputEvent(Boolean predicate, Event event) {
		outputEvents.get(predicate).add(event);
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
