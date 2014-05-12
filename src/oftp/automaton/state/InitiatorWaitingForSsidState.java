package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.*;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.idle.InitiatorSsidNegotiationPredicate;


public class InitiatorWaitingForSsidState extends OftpAbstractState {

	public static final String NAME = "I_WF_SSID";
	
	public InitiatorWaitingForSsidState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition t1 = new Transition() //D:P2
				.setPredicate(new InitiatorSsidNegotiationPredicate(oftp))
				.addAction(true, new InitializeInitiatorSessionAction(oftp))
				.setNextState(true, new IdleSpeakerState(oftp))
				.addAction(false, new EndSessionAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE))
				.addAction(false, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?
		Transition t2 = new Transition() //F
				.addAction(new CreateFAbortRequestAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
				.setNextState(new IdleState(oftp));
		Transition userErrorTransition = new Transition()
				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(new IdleState(oftp));

		this.addTranstion(new StartSessionArchetype(), t1);
		this.addTranstion(new EndSessionArchetype(EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE), t2);
		this.addTranstion(new FConnectionResponseArchetype(), userErrorTransition);
	}
}
