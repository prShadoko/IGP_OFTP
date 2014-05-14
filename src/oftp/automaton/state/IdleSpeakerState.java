package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.action.idlesp.CreateStartFileAction;
import oftp.automaton.archetype.monitor.input.FStartFileRequestArchetype;
import oftp.automaton.predicate.idlesp.RestartRequestedNotSupportedPredicate;


public class IdleSpeakerState extends OftpAbstractState {

	public static final String NAME = "IDLESP";
	
	public IdleSpeakerState(OftpAutomaton oftp) {
		super(oftp, NAME);

	}

	public void init() {
//		Transition a = new Transition()
//				.addAction(new CreateEndToEndResponseAction(oftp))
//				.setNextState(true, new WaitingForReadyToRetieveState(oftp));

		Transition b = new Transition()
				.setPredicate(new RestartRequestedNotSupportedPredicate(oftp))
				.addAction(true, new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(true, new IdleState(oftp))
				.addAction(false, new CreateStartFileAction(oftp))
				.setNextState(false, new OpenOutPendingState(oftp));

//		Transition c = new Transition()
//				.addAction(new CreateEndSessionAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION))
//				.addAction(new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.DISTANT))
//				.setNextState(new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

//		Transition d = new Transition()
//				.addAction(new CreateChangeDirectionAction(oftp))
//				.setNextState(new IdleListenerChangeDirectionRequestReceivedState(oftp));

//		Transition q = new Transition()
//				.setPredicate(new ReleaseRequestReasonIsNormalPredicate(oftp)) //TODO: verifier si Reason = Normal
//				.addAction(true, new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
//				.setNextState(true, new IdleState(oftp))
//				.addAction(false, new CreateEndSessionAction(oftp))
//				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

//		Transition u = new Transition()
//				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
//				.setNextState(new IdleState(oftp));

//		this.addTransition(new EndToEndResponseRequestArchetype(), a);
		this.addTransition(new FStartFileRequestArchetype(), b);
//		this.addTransition(new StartFilePositiveAnswerArchetype(), c);
//		this.addTransition(new StartFileNegativeAnswerArchetype(), c);
//		this.addTransition(new ChangeDirectionArchetype(), c);
//		this.addTransition(new SetCreditArchetype(), c);
//		this.addTransition(new ReadyToReceiveArchetype(), c);
//		this.addTransition(new ChangeDirectionRequestArchetype(), d);
//		this.addTransition(new FReleaseRequestArchetype(), q);
//		this.addTransition(new FDataRequestArchetype(), u);
	}
}
