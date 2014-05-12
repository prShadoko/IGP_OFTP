package oftp.automaton.state;

import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortRequestAction;
import oftp.automaton.action.InitSocketAction;
import oftp.automaton.action.CreateSsrmAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.monitor.input.NetworkConnectionIndicationArchetype;
import oftp.automaton.predicate.IsInitiatorPredicate;
import automaton.action.Action;
import automaton.predicate.Predicate;
import automaton.transition.Transition;


public class IdleState extends OftpAbstractState {

	public static final String NAME = "IDLE";
	
	public IdleState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
	
	public IdleState init() {

		Predicate p3 = new IsInitiatorPredicate(oftp);
		
		Action initSocketAction = new InitSocketAction(oftp);
		Action createSsrmEventAction = new CreateSsrmAction(oftp);
		Action createNetworkDisconnectionRequestEventAction = new CreateFAbortRequestAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.LOCAL);

		Transition fConReqIWfRmTransition = new Transition();
		fConReqIWfRmTransition.addAction(initSocketAction);
		fConReqIWfRmTransition.setNextState(new InitiatorWaitingForReadyMessageState(oftp));

		Transition b = new Transition()
			.setPredicate(p3)
			.addAction(true, createNetworkDisconnectionRequestEventAction)
			.addAction(createNetworkDisconnectionRequestEventAction)
			.setNextState(true, this)
			.addAction(false, initSocketAction)
			.addAction(false, createSsrmEventAction)
			.setNextState(false, new AcceptorNetworkConnectionOnlyState(oftp));

		addTranstion(new FConnectionRequestArchetype(), fConReqIWfRmTransition);
		addTranstion(new NetworkConnectionIndicationArchetype(), b);
		
		return this;
		
	}
}
