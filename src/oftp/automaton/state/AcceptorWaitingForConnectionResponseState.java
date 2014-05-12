package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.network.StartSessionArchetype;

public class AcceptorWaitingForConnectionResponseState extends OftpAbstractState {

	public static final String NAME = "A_WF_CONRS";
	
	public AcceptorWaitingForConnectionResponseState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition f = new Transition()
			.addAction(new CreateFAbortIndicationAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
			.setNextState(oftp.getIdleState());
		
		Transition g = new Transition()
			;

		addTranstion(new StartSessionArchetype(), f);
		addTranstion(new FConnectionResponseArchetype(), g);
	}


}
