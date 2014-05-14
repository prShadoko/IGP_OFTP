package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.opop.CreateFStartFileConfirmationAction;
import oftp.automaton.archetype.network.StartFilePositiveAnswerArchetype;
import automaton.transition.Transition;


public class OpenOutPendingState extends OftpAbstractState {

	public static final String NAME = "OPOP";
	
	public OpenOutPendingState(OftpAutomaton oftp) {
		super(oftp, NAME);
	
		Transition k = new Transition()
			.addAction(true, new CreateFStartFileConfirmationAction(oftp))
			.setNextState(true, new OpenOutState(oftp));
		
		addTransition(new StartFilePositiveAnswerArchetype(), k);
	}
}
