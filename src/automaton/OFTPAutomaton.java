package automaton;

import state.State;


public class OFTPAutomaton implements Automaton {

	private State state;
	
	public OFTPAutomaton(State state) {
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
