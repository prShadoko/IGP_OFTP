package automaton.action;

import automaton.event.Event;

public interface Action {

	void execute(Event inputEvent);
}
