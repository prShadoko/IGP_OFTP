package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.AbortOrigin;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateSsidAction;
import oftp.automaton.action.UserErrorAction;
import oftp.automaton.archetype.monitor.input.FConnectionResponseArchetype;
import oftp.automaton.archetype.network.StartSessionReadyMessageArchetype;

public class InitiatorWaitingForReadyMessageState extends OftpAbstractState {

	public static final String NAME = "I_WF_RM";
	
	public InitiatorWaitingForReadyMessageState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition t1 = new Transition()
				.addAction(new CreateSsidAction(oftp))
				.setNextState(new InitiatorWaitingForSsidState(oftp));
		Transition userErrorTransition = new Transition()
				.addAction(new UserErrorAction(oftp, EndSessionAnswerReason.PROTOCOL_VIOLATION, AbortOrigin.LOCAL))
				.setNextState(new IdleState(oftp));

		this.addTransition(new StartSessionReadyMessageArchetype(), t1);
		this.addTransition(new FConnectionResponseArchetype(), userErrorTransition);
	}

}
