package oftp.automaton;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;

import oftp.automaton.event.network.NetworkEvent;
import oftp.automaton.network.NetworkLayer;
import pattern.publish.subscribe.Publisher;
import pattern.publish.subscribe.Subscriber;
import automaton.AbstractAutomaton;
import automaton.event.Event;
import automaton.state.State;

public class OFTPAutomaton extends AbstractAutomaton {

	private int listenPort;
	private ServerSocket serverSocket;
	private NetworkLayer networkLayer;

	public OFTPAutomaton(State state, int listenPort) {
		super(state);
		this.listenPort = listenPort;
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
		try {
			networkLayer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public NetworkLayer getNetworkLayer() {
		return networkLayer;
	}

	public void setNetworkLayer(NetworkLayer networkLayer) {
		this.networkLayer = networkLayer;
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

}
