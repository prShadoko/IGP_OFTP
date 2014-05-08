package automaton.action;

import automaton.event.Event;
import automaton.exception.ActionExecutionExeption;

public interface Action {

	void execute(Event<?> inputEvent) throws ActionExecutionExeption;
}
