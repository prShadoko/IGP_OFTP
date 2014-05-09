package automaton.predicate;

import automaton.event.Event;


public interface Predicate {
	
	boolean check(Event<?> inputEvent);
}
