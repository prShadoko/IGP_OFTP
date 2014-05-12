package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.IncompatibleCapModePredicate;
import automaton.predicate.Predicate;
import automaton.transition.Transition;

public class AcceptorNetworkConnectionOnlyState extends OftpAbstractState {

	public static final String NAME = "A_NC_ONLY";
	
	public AcceptorNetworkConnectionOnlyState(OftpAutomaton oftp) {
		super(oftp, NAME);
		
		Predicate incompatibleCapMode = new IncompatibleCapModePredicate(oftp);
		
		Transition t1 = new Transition();
			
		Transition userErrorTransition = new Transition()
			.addAction(new UserErrorAction(oftp))
			.setNextState(oftp.getIdleState());

		this.addTranstion(new StartSessionArchetype(), t1);
		this.addTranstion(new FConnectionRequestArchetype(), userErrorTransition);
	}


}
