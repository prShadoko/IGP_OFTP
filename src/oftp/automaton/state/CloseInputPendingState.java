package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.clip.CreateEndFileNegativeAnswerAction;
import oftp.automaton.action.clip.CreateEndFilePositiveAnswerAction;
import oftp.automaton.archetype.monitor.input.NegativeFCloseFileResponseArchetype;
import oftp.automaton.archetype.monitor.input.PositiveFCloseFileResponseArchetype;
import oftp.automaton.predicate.clip.ChangeDirectionRequestedPredicate;


public class CloseInputPendingState extends OftpAbstractState {

	public static final String NAME = "CLIP";
	
	public CloseInputPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);

//		Transition b = new Transition();
//		Transition d = new Transition();
		Transition k1 = new Transition()
				.setPredicate(new ChangeDirectionRequestedPredicate(oftp))
				.addAction(true, new CreateEndFilePositiveAnswerAction(oftp))
				.setNextState(true, new WaitForChangeDirectionState(oftp))
				.addAction(false, new CreateEndFilePositiveAnswerAction(oftp))
				.setNextState(false, new IdleListenerState(oftp));
		Transition k2 = new Transition()
				.addAction(new CreateEndFileNegativeAnswerAction(oftp))
				.setNextState(new IdleListenerState(oftp));
//		Transition u = new Transition();

//		addTransition(, b);
//		addTransition(, d);
		addTransition(new PositiveFCloseFileResponseArchetype(), k1);
		addTransition(new NegativeFCloseFileResponseArchetype(), k2);
//		addTransition(, u);
	}
}
