package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.clop.CreateChangeDirectionAction;
import oftp.automaton.action.clop.CreateNegativeFCloseFileConfirmationAction;
import oftp.automaton.action.clop.CreatePositiveListenerFCloseFileConfirmationAtion;
import oftp.automaton.action.clop.CreatePositiveSpeakerFCloseFileConfirmationAtion;
import oftp.automaton.archetype.network.EndFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.EndFilePositiveAnswerArchetype;
import oftp.automaton.predicate.clop.ChangeDirectionPredicate;

public class CloseOutPendingState extends OftpAbstractState {

	public static final String NAME = "CLOP";

	public CloseOutPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition c = new Transition()
			    .setPredicate(new ChangeDirectionPredicate(oftp))
				.addAction(true, new CreatePositiveListenerFCloseFileConfirmationAtion(oftp))
				.addAction(true, new CreateChangeDirectionAction(oftp))
				.setNextState(true, new IdleListenerState(oftp))
				.addAction(false, new CreatePositiveSpeakerFCloseFileConfirmationAtion(oftp))
				.setNextState(false, new IdleSpeakerState(oftp));
		Transition d = new Transition()
				.addAction(false, new CreateNegativeFCloseFileConfirmationAction(oftp))
				.setNextState(false, new IdleSpeakerState(oftp));
//		Transition u = new Transition()

		addTransition(new EndFilePositiveAnswerArchetype(), c);
		addTransition(new EndFileNegativeAnswerArchetype(), d);
//		addTransition(, u);
	}
}
