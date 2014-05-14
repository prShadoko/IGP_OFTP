package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.CreateFAbortRequestAction;
import oftp.automaton.action.InitializeInitiatorSessionAction;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.action.awfconrs.CreateEndSessionAction;
import oftp.automaton.action.iwfssid.CreateFConnectionConfirmationAction;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.idle.InitiatorSsidNegotiationPredicate;


public class InitiatorWaitingForSsidState extends OftpAbstractState {

	public static final String NAME = "I_WF_SSID";
	
	public InitiatorWaitingForSsidState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition d = new Transition()
				.setPredicate(new InitiatorSsidNegotiationPredicate(oftp))
				.addAction(true, new InitializeInitiatorSessionAction(oftp))
				.addAction(true, new CreateFConnectionConfirmationAction(oftp))
				.setNextState(true, oftp.getIdleSpeakerState())
				.addAction(false, new CreateEndSessionAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE))
				.addAction(false, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
				.setNextState(false, new IdleState(oftp));//TODO: Etat intermediaire WF_NDISC ?

		Transition f = new Transition() //F
				.addAction(new CreateFAbortRequestAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
				.setNextState(new IdleState(oftp));

		Transition u = new Transition()
				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(new IdleState(oftp));

		this.addTransition(new StartSessionArchetype(), d);
		this.addTransition(new EndSessionArchetype(EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE), f);
		this.addTransition(new FConnectionResponseArchetype(), u);
	}
}
