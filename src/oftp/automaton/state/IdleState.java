package oftp.automaton.state;

import automaton.action.Action;
import automaton.state.StateImpl;
import automaton.transition.Transition;
import oftp.automaton.OFTPAutomaton;
import oftp.automaton.action.InitSocketAction;
import oftp.automaton.action.SendSSRMAction;
import oftp.automaton.event.monitor.FConnectRequestArchetype;
import oftp.automaton.event.monitor.NetworkConnectionIndicationArchetype;


public class IdleState extends StateImpl {

	public IdleState(OFTPAutomaton oftp) {
		super("IDLE");

		Action initSocketAction = new InitSocketAction(oftp);
		Action sendSSRMAction = new SendSSRMAction(oftp);

		Transition fConReqIWfRmTransition = new Transition();
		fConReqIWfRmTransition.addAction(initSocketAction);
		fConReqIWfRmTransition.setNextState(new InitiatorWaitingForReadyMessageState());

		Transition nConIndANcOnlyTransition = new Transition();
		nConIndANcOnlyTransition.addAction(initSocketAction);
		nConIndANcOnlyTransition.addAction(sendSSRMAction);
		nConIndANcOnlyTransition.setNextState(new AcceptorNetworkConnectionOnlyState());

		addTranstion(new FConnectRequestArchetype(), fConReqIWfRmTransition);
		addTranstion(new NetworkConnectionIndicationArchetype(), nConIndANcOnlyTransition);
	}
}
