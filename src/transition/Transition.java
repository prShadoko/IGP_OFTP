package transition;

public interface Transition {

	void update(Automaton automaton);
	
	Collection<Action> getActions()
}
