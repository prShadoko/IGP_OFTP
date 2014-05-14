package oftp.automaton.state;

import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.awfconrs.CreateEndSessionAction;
import oftp.automaton.action.opop.CreateNegativeFStartFileConfirmationAction;
import oftp.automaton.action.opop.CreatePositiveFStartFileConfirmationAction;
import oftp.automaton.archetype.network.StartFileNegativeAnswerArchetype;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;
import oftp.automaton.predicate.opop.RestartPositionGreaterThanRequestedPredicate;
import automaton.transition.Transition;


public class OpenOutPendingState extends OftpAbstractState {

	public static final String NAME = "OPOP";
	
	public OpenOutPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);

//		Transition k = new Transition()
//			.addAction(true, new CreateFStartFileConfirmationAction(oftp))
//			.setNextState(true, new OpenOutState(oftp));
//		
//		addTransition(new StartFilePositiveAnswerArchetype(), k);


		Transition k = new Transition()
				.setPredicate(new RestartPositionGreaterThanRequestedPredicate(oftp))
				.addAction(true, new CreateEndSessionAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION))
				.addAction(true, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.DISTANT))
				.setNextState(true, new IdleState(oftp))//TODO: Etat intermediaire WF_NDISC ?
				.addAction(false, new CreatePositiveFStartFileConfirmationAction(oftp))
//				.addAction(false, new )// Action 12: V.Credit_S = V.Window
				.setNextState(false, new OpenOutState(oftp));

		Transition l = new Transition()
				.addAction(new CreateNegativeFStartFileConfirmationAction(oftp))
				.setNextState(oftp.getIdleSpeakerState());

// 		Transition c = new Transition()
//				.addAction(new CreateEndSessionAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION))
//				.addAction(new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.DISTANT))
//				.setNextState(new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

//		Transition q = new Transition()
//				.setPredicate(new ReleaseRequestReasonIsNormalPredicate(oftp)) //TODO: verifier si Reason = Normal
//				.addAction(true, new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
//				.setNextState(true, new IdleState(oftp))
//				.addAction(false, new CreateEndSessionAction(oftp))
//				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

//		Transition u = new Transition()
//				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
//				.setNextState(new IdleState(oftp));


		this.addTransition(new StartFilePositiveAnswerArchetype(), k);
		this.addTransition(new StartFileNegativeAnswerArchetype(), l);
	}
}
