package oftp.automaton;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import oftp.automaton.event.network.archetype.OftpNetworkArchetype;
import oftp.automaton.network.NetworkLayer;
import oftp.automaton.network.OftpNetworkEventFactory;
import oftp.automaton.state.IdleState;
import oftp.service.OftpNetworkArchetypeProviderService;
import automaton.AbstractAutomaton;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.AutomatonException;
import automaton.state.State;

public class OftpAutomaton extends AbstractAutomaton {

	private int listenPort;
	private ServerSocket serverSocket;
	private NetworkLayer networkLayer;
	private OftpNetworkEventFactory networkEventFactory = new OftpNetworkEventFactory();

	private OftpNetworkArchetypeProviderService archtypeProviderService = new OftpNetworkArchetypeProviderService();

	public OftpAutomaton() {
		super();

		Collection<OftpNetworkArchetype> archetypes = archtypeProviderService.getArchetype();
		networkEventFactory.addArchetypes(archetypes);
	}

	public static OftpAutomaton build() {

		OftpAutomaton oftp = new OftpAutomaton();
		State idle = new IdleState(oftp);
		oftp.setState(idle);

		return oftp;
	}

	@Override
	protected void setUp() throws AutomatonException {
		try {
			serverSocket = new ServerSocket(listenPort);
		} catch(IOException e) {
			throw new AutomatonException("Error while socket initializations", e);
		}
	}

	@Override
	protected void tearDown() {
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public NetworkLayer getNetworkLayer() {
		return networkLayer;
	}

	public void setSocket(Socket socket) {
		if(null != networkLayer) {
			try {
				networkLayer.close();
			} catch(IOException e) {
				new AutomatonException("Error while closing network layer.", e).printStackTrace();
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
}
