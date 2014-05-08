package automaton;

import automaton.event.Event;

public interface Automaton extends Runnable {

	void addOutputEvent(Event<?> event);

	void sendOutputEvents();
	
	Event<?> receiveEvent();
}
