package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.CreateFAbortIndicationAction;
import oftp.automaton.action.opi.CreateFCloseFileIndicationAction;
import oftp.automaton.action.opi.CreateFDataIndicationAction;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;
import oftp.automaton.archetype.network.EndFileArchetype;
import oftp.automaton.archetype.network.EndSessionArchetype;


public class OpenInputState extends OftpAbstractState {

	public static final String NAME = "OPI";
	
	public OpenInputState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Transition d = new Transition()
			.addAction(new CreateFAbortIndicationAction(oftp))
			.setNextState(oftp.getIdleState());

		Transition i = new Transition()
			.addAction(new CreateFDataIndicationAction(oftp))
			.setNextState(this);
		
		Transition j = new Transition()
			.addAction(new CreateFCloseFileIndicationAction(oftp))
			.setNextState(new CloseInputPendingState(oftp));

		addTransition(new EndSessionArchetype(), d);
		addTransition(new DataExchangeBufferArchetype(), i);
		addTransition(new EndFileArchetype(), j);
	}
}
