package oftp.automaton.action;

import automaton.Automaton;
import automaton.action.Action;

public class Coucou implements Action {

	@Override
	public void execute(Automaton automaton) {
		System.out.println("Coucou ! :D");
	}

}
