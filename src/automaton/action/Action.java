package automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionException;

public interface Action {

	void execute(Event<?> inputEvent) throws ActionExecutionException;
}
