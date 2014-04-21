package event;

import automaton.Automaton;

public interface Event {
	String getName();
	void send();
}
