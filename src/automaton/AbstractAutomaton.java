package automaton;

import state.State;

public abstract class AbstractAutomaton implements Automaton {

private State state;
	
	public AbstractAutomaton(State state) {
		setState(state);
	}
	
	@Override
	public void run() {
		while(null != state) {
			state.run(this);
		}
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

}
