package oftp.automaton.state;

import automaton.predicate.Predicate;
import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.CreateSsidAction;
import oftp.automaton.action.InitializeInitiatorSessionAction;
import oftp.automaton.action.awfconrs.CreateEndSessionAction;
import oftp.automaton.action.awfconrs.InitializeAcceptorSessionAction;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.idle.AcceptorSsidNegotiationPredicate;
import automaton.predicate.Predicate;
import automaton.transition.Transition;

public class AcceptorWaitingForConnectionResponseState extends OftpAbstractState {

	public static final String NAME = "A_WF_CONRS";
	
	public AcceptorWaitingForConnectionResponseState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition f = new Transition()
			.addAction(new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
			.setNextState(oftp.getIdleState());
		
		Predicate p2 = new AcceptorSsidNegotiationPredicate(oftp);
		Transition g = new Transition()
			.setPredicate(p2)
			.addAction(true, new InitializeAcceptorSessionAction(oftp))
			.addAction(true, new CreateSsidAction(oftp))
			.setNextState(true, oftp.getIdleListenerState())
			.addAction(false, new CreateEndSessionAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE))
			.addAction(false, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.DISTANT))
			.setNextState(false, oftp.getIdleState());

		addTransition(new StartSessionArchetype(), f);
		addTransition(new FConnectionResponseArchetype(), g);
	}


}
