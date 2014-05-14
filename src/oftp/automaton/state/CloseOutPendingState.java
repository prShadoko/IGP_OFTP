package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;

public class CloseOutPendingState extends OftpAbstractState {

	public static final String NAME = "CLOP";

	public CloseOutPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);

//		Transition c = new Transition()
//			    .setPredicate(new ChangeDirectionPredicate(oftp))
//				.addAction(true, CreatePositiveFCloseFileConfirmationAtion(oftp))//TODO: SP=No
//				.addAction(true, CreateChangeDirectionAction(oftp))
//				.setNextState(true, new IdleListenerState(oftp))
//				.addAction(false, CreatePositiveFCloseFileConfirmationAtion(oftp))//TODO: SP=Yes
//				.setNextState(false, new IdleSpeakerState(oftp));
//		Transition d = new Transition()
//				.addAction(false, new CreateNegativeFCloseFileConfirmationAction(oftp))
//				.setNextState(false, new IdleSpeakerState(oftp));
//		Transition u = new Transition()

//		addTransition(new EndFilePositiveAnswerArchetype(), c);
//		addTransition(new EndFileNegativeAnswerArchetype(), d);
//		addTransition(, u);



	}
}
