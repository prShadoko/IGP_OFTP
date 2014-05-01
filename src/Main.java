import oftp.automaton.OFTPAutomaton;
import oftp.automaton.event.monitor.MonitorEvent;
import oftp.automaton.state.Idle;
import oftp.automaton.state.InitiatorWaitForReadyMessage;
import oftp.monitor.Monitor;
import automaton.event.Event;
import automaton.state.State;
import automaton.transition.Transition;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Event fConnectRequest = new MonitorEvent("F_CONNECT_RQ");

		State idle = new Idle();
		State Iwfrm = new InitiatorWaitForReadyMessage();
		
		Transition transition = new Transition();
		//t.addOutputEvent(event);
		//t.addAction(action);
		transition.setNextState(Iwfrm);
		
		idle.addTranstion(fConnectRequest, transition);
		
		OFTPAutomaton automaton = new OFTPAutomaton(idle, 10101);
		
		// -------------- O -------------- //
		
		Monitor m = new Monitor();
		m.subscribe(MonitorEvent.class, automaton);
		
		new Thread(m).start();
		
		automaton.run();
	}

}
