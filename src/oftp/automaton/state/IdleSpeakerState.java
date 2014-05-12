package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.monitor.input.FDataRequestArchetype;


public class IdleSpeakerState extends OftpAbstractState {

	public static final String NAME = "IDLESP";
	
	public IdleSpeakerState(OftpAutomaton oftp) {
		super(oftp, NAME);

//ABCDQ
//		Transition t1 = new Transition() //D
//				.setPredicate(new SsidNegotiationPredicate(oftp))
//				.addAction(true, new InitializeSessionAction(oftp))
//				.setNextState(true, new IdleSpeakerState(oftp))
//				.addAction(false, new EndSessionAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE))
//				.addAction(false, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
//				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?
//		Transition t2 = new Transition() //F
//				.addAction(new CreateFAbortRequestAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
//				.setNextState(new IdleState(oftp));
		Transition userErrorTransition = new Transition()
				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(new IdleState(oftp));

//		this.addTranstion(new StartSessionArchetype(), t1);
//		this.addTranstion(new EndSessionArchetype(EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE), t2);
		this.addTranstion(new FDataRequestArchetype(), userErrorTransition);
//		this.addTranstion(new F_REL_RQ);
	}
}
