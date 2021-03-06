package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.opip.CreateStartFileNegativeAnswerAction;
import oftp.automaton.action.opip.CreateStartFilePositiveAnswerAction;
import oftp.automaton.archetype.monitor.input.NegativeFStartFileResponseArchetype;
import oftp.automaton.archetype.monitor.input.PositiveFStartFileResponseArchetype;


public class OpenInputPendingState extends OftpAbstractState {

	public static final String NAME = "OPIP";
	
	public OpenInputPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);
		
		// TODO P4

		Transition h1 = new Transition()
			.addAction(true, new CreateStartFilePositiveAnswerAction(oftp))
			.setNextState(true, new OpenInputState(oftp));

		Transition h2 = new Transition()
			.addAction(true, new CreateStartFileNegativeAnswerAction(oftp))
			.setNextState(true, oftp.getIdleListenerState());

		addTransition(new PositiveFStartFileResponseArchetype(), h1);
		addTransition(new NegativeFStartFileResponseArchetype(), h2);
	}
}
