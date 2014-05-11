package oftp.automaton.state;

import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.InitSocketAction;
import oftp.automaton.action.SendSSRMAction;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.monitor.input.NetworkConnectionIndicationArchetype;
import automaton.action.Action;
import automaton.transition.Transition;


public class IdleState extends OftpAbstractState {

	public static final String NAME = "IDLE";
	
	public IdleState(OftpAutomaton oftp) {
		super(oftp, NAME);

		Action initSocketAction = new InitSocketAction(oftp);
		Action sendSSRMAction = new SendSSRMAction(oftp);

		Transition fConReqIWfRmTransition = new Transition();
		fConReqIWfRmTransition.addAction(initSocketAction);
		fConReqIWfRmTransition.setNextState(new InitiatorWaitingForReadyMessageState(oftp));

		Transition nConIndANcOnlyTransition = new Transition();
		nConIndANcOnlyTransition.addAction(initSocketAction);
		nConIndANcOnlyTransition.addAction(sendSSRMAction);
		nConIndANcOnlyTransition.setNextState(new AcceptorNetworkConnectionOnlyState(oftp));

		addTranstion(new FConnectionRequestArchetype(), fConReqIWfRmTransition);
		addTranstion(new NetworkConnectionIndicationArchetype(), nConIndANcOnlyTransition);
	}
}
