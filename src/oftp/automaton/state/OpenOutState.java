package oftp.automaton.state;

import automaton.transition.Transition;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.opo.CreateEndFileAction;
import oftp.automaton.action.opo.CreateExchangeBufferAction;
import oftp.automaton.archetype.monitor.input.FCloseFileRequestArchetype;
import oftp.automaton.archetype.monitor.input.FDataRequestArchetype;
import oftp.automaton.predicate.opo.SpeakerCreditExhaustedPredicate;


public class OpenOutState extends OftpAbstractState {

	public static final String NAME = "OPO";
	
	public OpenOutState(OftpAutomaton oftp) {
		super(oftp, NAME);

//		Transition c = new Transition()
		Transition m = new Transition()
				.setPredicate(new SpeakerCreditExhaustedPredicate(oftp))
//				.addAction(true, new BuildExchangeBufferAction())
//				.addAction(true, )// Action 13: V.Credit_S = V.Credit_S - 1
//				.setNextState(true, OpenOutWaitForCreditState())
				.addAction(false, new CreateExchangeBufferAction(oftp))
//				.addAction(false, )// Action 13: V.Credit_S = V.Credit_S - 1
				.setNextState(false, new OpenOutState(oftp));
//		Transition o = new Transition()
//		Transition p = new Transition()
//		Transition q = new Transition()
//		Transition u = new Transition()
		Transition a2 = new Transition()
				.addAction(new CreateEndFileAction(oftp))
//				.addAction()//Action 7:  Set V.Credit_S = 0
				.setNextState(new CloseOutPendingState(oftp));
//		Transition b2 = new Transition();

//		addTransition(, c);
		addTransition(new FDataRequestArchetype(), m);
//		addTransition(, o);
//		addTransition(, p);
//		addTransition(, q);
//		addTransition(, u);
		addTransition(new FCloseFileRequestArchetype(), a2);
//		addTransition(, b2);
	}
}
