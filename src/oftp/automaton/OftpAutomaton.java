package oftp.automaton;

import java.io.IOException;
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

	private NetworkLayer networkLayer;
	private OftpNetworkEventFactory networkEventFactory = new OftpNetworkEventFactory();

	private OftpNetworkArchetypeProviderService archtypeProviderService = new OftpNetworkArchetypeProviderService();

	// Local OFTP variables
	int bufferSize;
	// Called-addr Address Used to build O.F_CONNECT_IND.Called-addr
	// Calling-addr Address To build O.F_CONNECT_IND.Calling-addr
	boolean compression;
	int creditListener;
	int creditSpeaker;
	String id;
	char mode;
	String password;
	Event<?> requestBuffer;
	boolean restart;
	int restartPosition;
	int window;

	// Local OFTP constants
	boolean capCompression;
	char capInit;
	char capMode;
	int maximumBufferSize;
	int maximumWindow;

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

	}

	@Override
	protected void tearDown() {

	}

	public NetworkLayer getNetworkLayer() {
		return networkLayer;
	}

	public void setSocket(Socket socket) {
		if (null != networkLayer) {
			try {
				networkLayer.close();
			} catch (IOException e) {
				new AutomatonException("Error while closing network layer.", e).printStackTrace();
			}
		}

		this.networkLayer = new NetworkLayer(socket, networkEventFactory);
		networkLayer.subscribe(Event.class, this);
		this.subscribe(NetworkEvent.class, networkLayer);
		new Thread(networkLayer).start();
	}

	public OftpNetworkEventFactory getNetworkEventFactory() {
		return networkEventFactory;
	}

	public void setNetworkEventFactory(OftpNetworkEventFactory networkEventFactory) {
		this.networkEventFactory = networkEventFactory;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public boolean isCompression() {
		return compression;
	}

	public void setCompression(boolean compression) {
		this.compression = compression;
	}

	public int getCreditListener() {
		return creditListener;
	}

	public void setCreditListener(int creditListener) {
		this.creditListener = creditListener;
	}

	public int getCreditSpeaker() {
		return creditSpeaker;
	}

	public void setCreditSpeaker(int creditSpeaker) {
		this.creditSpeaker = creditSpeaker;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getMode() {
		return mode;
	}

	public void setMode(char mode) {
		this.mode = mode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Event<?> getRequestBuffer() {
		return requestBuffer;
	}

	public void setRequestBuffer(Event<?> requestBuffer) {
		this.requestBuffer = requestBuffer;
	}

	public boolean isRestart() {
		return restart;
	}

	public void setRestart(boolean restart) {
		this.restart = restart;
	}

	public int getRestartPosition() {
		return restartPosition;
	}

	public void setRestartPosition(int restartPosition) {
		this.restartPosition = restartPosition;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public boolean isCapCompression() {
		return capCompression;
	}

	public char getCapInit() {
		return capInit;
	}

	public char getCapMode() {
		return capMode;
	}
	
	public int getMaximumBufferSize() {
		return maximumBufferSize;
	}

	public int getMaximumWindow() {
		return maximumWindow;
	}
}
