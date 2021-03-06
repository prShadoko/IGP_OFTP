package oftp.automaton.state;

import automaton.predicate.Predicate;
import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.idleli.CreateStartFileIndicationAction;
import oftp.automaton.archetype.network.StartFileArchetype;
import oftp.automaton.predicate.idleli.InvalidStartFileCommandPredicate;


public class IdleListenerState extends OftpAbstractState {

	public static final String NAME = "IDLELI";
	
	public IdleListenerState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
	
	public void init() {

		Predicate p1 = new InvalidStartFileCommandPredicate(oftp);
		
		Transition a = new Transition()
			.setPredicate(p1)
			.addAction(true, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.INVALID_DATA, AbortOrigin.LOCAL))
			.setNextState(true, oftp.getIdleState())
			.addAction(false, new CreateStartFileIndicationAction(oftp))
			.setNextState(false, new OpenInputPendingState(oftp));
		
		addTransition(new StartFileArchetype(), a);
	}
}
