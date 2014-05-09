package automaton.transition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import automaton.action.Action;
import automaton.predicate.Predicate;
import automaton.state.State;

public class Transition {

	Predicate predicate;

	Map<Boolean, Collection<Action>> actions;
	Map<Boolean, State> nextStates;

	public Transition() {
		predicate = null;

		actions = new HashMap<>();
		actions.put(true, new LinkedList<Action>());
		actions.put(false, new LinkedList<Action>());

		nextStates = new HashMap<>();
	}

	public Transition setPredicate(Predicate predicate) {
		this.predicate = predicate;
		return this;
	}

	public Transition setNextState(State nextState) {
		setNextState(true, nextState);
		return this;
	}

	public Transition setNextState(Boolean predicate, State nextState) {
		nextStates.put(predicate, nextState);
		return this;
	}

	public void addAction(Action action) {
		addAction(true, action);
	}

	public void addAction(Boolean predicate, Action action) {
		actions.get(predicate).add(action);
	}

	@SuppressWarnings("unchecked")
	public Collection<Action> getActions() {
		return (Collection<Action>) get(actions);
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
