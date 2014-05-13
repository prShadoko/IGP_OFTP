package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;


public class IdleSpeakerState extends OftpAbstractState {

	public static final String NAME = "IDLESP";
	
	public IdleSpeakerState(OftpAutomaton oftp) {
		super(oftp, NAME);
/*TODO: créer les (16!) classes manquantes... youpi ! \o/
		Transition t1 = new Transition() //A
				.addAction(new CreateEndToEndResponseAction(oftp))
				.setNextState(true, new WaitingForReadyToRetieveState(oftp));

		Transition t2 = new Transition() //B
				.setPredicate(new RestartRequestedNotSupportedPredicate(oftp))
				.addAction(true, new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(true, new IdleState(oftp))
				.addAction(false, new CreateStartFileAction(oftp))
				.setNextState(false, new OpenOutPendingState(oftp));

		Transition t3 = new Transition() //C
				.addAction(new CreateEndSessionAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION))
				.addAction(new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.DISTANT))
				.setNextState(new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

		Transition t4 = new Transition() //D
				.addAction(new CreateChangeDirectionAction(oftp))
				.setNextState(new IdleListenerChangeDirectionRequestReceivedState(oftp));

		Transition t5 = new Transition() //Q
				.setPredicate(new ReleaseRequestReasonIsNormalPredicate(oftp)) //TODO: verifier si Reason = Normal
				.addAction(true, new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(true, new IdleState(oftp))
				.addAction(false, new CreateEndSessionAction(oftp))
				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

		Transition t6 = new Transition()
				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(new IdleState(oftp));

		this.addTransition(new EndToEndResponseRequestArchetype(), t1);
		this.addTransition(new FStartFileRequestArchetype(), t2);
		this.addTransition(new StartFilePositiveAnswerArchetype(), t3);
		this.addTransition(new StartFileNegativeAnswerArchetype(), t3);
		this.addTransition(new ChangeDirectionArchetype(), t3);
		this.addTransition(new SetCreditArchetype(), t3);
		this.addTransition(new ReadyToReceiveArchetype(), t3);
		this.addTransition(new ChangeDirectionRequestArchetype(), t4);
		this.addTransition(new FReleaseRequestArchetype(), t5);
		this.addTransition(new FDataRequestArchetype(), t6);
*/
	}
}
