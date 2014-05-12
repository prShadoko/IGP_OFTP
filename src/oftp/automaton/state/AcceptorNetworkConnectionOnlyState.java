package oftp.automaton.state;

import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.action.anconly.CreateFConnectionIndicationAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;
import oftp.automaton.predicate.anconly.IncompatibleSsidAndCapModePredicate;
import automaton.action.Action;
import automaton.predicate.Predicate;
import automaton.transition.Transition;

public class AcceptorNetworkConnectionOnlyState extends OftpAbstractState {

	public static final String NAME = "A_NC_ONLY";
	
	public AcceptorNetworkConnectionOnlyState(OftpAutomaton oftp) {
		super(oftp, NAME);
		
		Predicate p4 = new IncompatibleSsidAndCapModePredicate(oftp);
		
		Action createFConnectionIndication = new CreateFConnectionIndicationAction(oftp);

		Transition e = new Transition()
			.setPredicate(p4)
			.setNextState(true, oftp.getIdleState())
			.addAction(false, createFConnectionIndication)
			.setNextState(false, new AcceptorWaitingForConnectionResponseState(oftp));
			
		Transition u = new Transition()
			.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
			.setNextState(oftp.getIdleState());

		this.addTranstion(new StartSessionArchetype(), e);
		this.addTranstion(new FConnectionRequestArchetype(), u);
	}


}
