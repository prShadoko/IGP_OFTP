package oftp.automaton.state;

import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.CreateSsrmAction;
import oftp.automaton.action.InitSocketAction;
import oftp.automaton.action.idle.SetModeFromFConnectionRequestAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.monitor.input.NetworkConnectionIndicationArchetype;
import oftp.automaton.predicate.idle.IsInitiatorPredicate;
import oftp.automaton.predicate.idle.IsModeCompatiblePredicate;
import automaton.action.Action;
import automaton.predicate.Predicate;
import automaton.transition.Transition;


public class IdleState extends OftpAbstractState {

	public static final String NAME = "IDLE";
	
	public IdleState(OftpAutomaton oftp) {
		super(oftp, NAME);
	}
	
	public IdleState init() {

		Predicate p1 = new IsModeCompatiblePredicate(oftp);
		Predicate p3 = new IsInitiatorPredicate(oftp);
		
		Action initSocketAction = new InitSocketAction(oftp);
		Action setModeFromFConnectionRequest = new SetModeFromFConnectionRequestAction(oftp);
		Action createSsrmEventAction = new CreateSsrmAction(oftp);
		Action createFAbortRequestEventAction = new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.LOCAL);

		
		Transition a = new Transition()
			.setPredicate(p1)
			.addAction(true, new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.MODE_OR_CAPABILITIES_INCOMPATIBLE, AbortOrigin.LOCAL))
			.setNextState(true, oftp.getIdleState())
			.addAction(false, initSocketAction)
			.addAction(false, setModeFromFConnectionRequest)
			.setNextState(false, new InitiatorWaitingForReadyMessageState(oftp));

		Transition b = new Transition()
			.setPredicate(p3)
			.addAction(true, createFAbortRequestEventAction)
			.setNextState(true, this)
			.addAction(false, initSocketAction)
			.addAction(false, createSsrmEventAction)
			.setNextState(false, new AcceptorNetworkConnectionOnlyState(oftp));

		addTranstion(new FConnectionRequestArchetype(), a);
		addTranstion(new NetworkConnectionIndicationArchetype(), b);
		
		return this;
		
	}
}
