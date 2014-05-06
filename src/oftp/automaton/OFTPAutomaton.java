package oftp.automaton;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import oftp.automaton.action.InitSocketAction;
import oftp.automaton.action.SendSSRMAction;
import oftp.automaton.event.monitor.FConnectRequestEvent;
import oftp.automaton.event.monitor.NetworkConnectionIndicationEvent;
import oftp.automaton.event.network.archetype.OFTPNetworkArchetype;
import oftp.automaton.network.NetworkLayer;
import oftp.automaton.network.OFTPNetworkEventFactory;
import oftp.automaton.state.AcceptorNetworkConnectionOnly;
import oftp.automaton.state.IdleState;
import oftp.automaton.state.InitiatorWaitForReadyMessageState;
import oftp.service.OFTPNetworkArchetypeProviderService;
import automaton.AbstractAutomaton;
import automaton.action.Action;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.state.State;
import automaton.transition.Transition;

public class OFTPAutomaton extends AbstractAutomaton {

	private int listenPort;
	private ServerSocket serverSocket;
	private NetworkLayer networkLayer;
	private OFTPNetworkEventFactory networkEventFactory = new OFTPNetworkEventFactory();
	
	private OFTPNetworkArchetypeProviderService archtypeProviderService = new OFTPNetworkArchetypeProviderService();

	public OFTPAutomaton(State state) {
		super(state);
		
		Collection<OFTPNetworkArchetype> archetypes = archtypeProviderService.getArchetype();
		networkEventFactory.addArchetypes(archetypes);
	}

	@Override
	protected void setUp() {
		try {
			serverSocket = new ServerSocket(listenPort);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void tearDown() {
		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		try {
//			networkLayer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public NetworkLayer getNetworkLayer() {
		return networkLayer;
	}

	public void setSocket(Socket socket) {
		if(null != networkLayer) {
			try {
				networkLayer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.networkLayer = new NetworkLayer(socket, networkEventFactory);
		networkLayer.subscribe(Event.class, this);
		this.subscribe(NetworkEvent.class, networkLayer);
		new Thread(networkLayer).start();
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public static OFTPAutomaton build() {
		
		State idle = new IdleState();
		OFTPAutomaton oftp = new OFTPAutomaton(idle);

		Action initSocketAction = new InitSocketAction(oftp);
		Action sendSSRMAction = new SendSSRMAction(oftp);
//		Action sendSSIDAction = new SendSSIDAction(oftp);
		
		Transition nConIndANcOnlyTransition = new Transition();
		nConIndANcOnlyTransition.addAction(initSocketAction);
		nConIndANcOnlyTransition.addAction(sendSSRMAction);
		nConIndANcOnlyTransition.setNextState(new AcceptorNetworkConnectionOnly());
		
		Transition fConReqIWfRmTransition = new Transition();
		fConReqIWfRmTransition.addAction(initSocketAction);
		fConReqIWfRmTransition.setNextState(new InitiatorWaitForReadyMessageState());

		idle.addTranstion(new NetworkConnectionIndicationEvent(), nConIndANcOnlyTransition);
		idle.addTranstion(new FConnectRequestEvent(), fConReqIWfRmTransition);
		
		return oftp;
	}
}
