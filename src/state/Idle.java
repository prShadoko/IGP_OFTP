package state;

import automaton.Automaton;


public class Idle implements State {

	@Override
	public void run(Automaton automaton) {
		System.out.println(" --- IDLE --- 	");
	}

}
