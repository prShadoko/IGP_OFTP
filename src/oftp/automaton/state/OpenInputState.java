package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.opi.CreateFDataIndicationAction;
import oftp.automaton.archetype.network.DataExchangeBufferArchetype;
import automaton.transition.Transition;


public class OpenInputState extends OftpAbstractState {

	public static final String NAME = "OPI";
	
	public OpenInputState(OftpAutomaton oftp) {
		super(oftp, NAME);
		
		Transition i = new Transition()
			.addAction(new CreateFDataIndicationAction(oftp))
			.setNextState(this);
		
		addTransition(new DataExchangeBufferArchetype(), i);
	}
}
