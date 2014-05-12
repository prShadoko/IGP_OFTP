package oftp.automaton;

import automaton.AbstractAutomaton;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.AutomatonException;
import oftp.automaton.archetype.network.OftpNetworkArchetype;
import oftp.automaton.network.NetworkLayer;
import oftp.automaton.network.OftpNetworkEventFactory;
import oftp.automaton.state.IdleState;
import oftp.service.OftpNetworkArchetypeProviderService;

import java.io.IOException;
import java.net.Socket;
import java.util.Collection;

public class OftpAutomaton extends AbstractAutomaton {

	private IdleState idle;
	
	private NetworkLayer networkLayer;
	private OftpNetworkEventFactory networkEventFactory = new OftpNetworkEventFactory();

	private OftpNetworkArchetypeProviderService archetypeProviderService = new OftpNetworkArchetypeProviderService();

	private Event<?> ssid;
	
	// Local OFTP variables
	int bufferSize;
	String calledAddresse;
	String callingAddresse;
	boolean compressionEnabled;
	int creditListener;
	int creditSpeaker;
	String id;
	CapabilityMode mode;
	String password;
	Event<?> requestBuffer;
	boolean restartEnabled;
	int restartPosition;
	int window;

	// Local OFTP constants
	boolean capCompression;
	CapabilityInit capInit;
	CapabilityMode capMode;
	int maximumBufferSize;
	int maximumWindow;

	public OftpAutomaton(boolean capCompression, CapabilityInit capInit, CapabilityMode capMode, int maximumBufferSize, int maximumWindow) {
		super();

		this.capCompression = capCompression;
		this.capInit = capInit;
		this.capMode = capMode;
		
		if (maximumWindow < 128) {
			maximumWindow = 128;
		} else if (maximumWindow >= 100000) {
			maximumWindow = 99999;
		}
		this.maximumBufferSize = maximumBufferSize;
		
		if (maximumWindow < 0) {
			maximumWindow = 0;
		} else if (maximumWindow >= 1000) {
			maximumWindow = 999;
		}
		this.maximumWindow = maximumWindow;

		Collection<OftpNetworkArchetype> archetypes = archetypeProviderService.getArchetype();
		networkEventFactory.addArchetypes(archetypes);
	}

	public static OftpAutomaton build(boolean capCompression, CapabilityInit capInit, CapabilityMode capMode, int maximumBufferSize, int maximumWindow) {

		OftpAutomaton oftp = new OftpAutomaton(capCompression, capInit, capMode, maximumBufferSize, maximumWindow);
		oftp.setState(oftp.getIdleState().init());

		return oftp;
	}

	@Override
	protected void setUp() throws AutomatonException {

	}

	@Override
	protected void tearDown() {

	}

	public void closeNetworkLayer() {
		try {
			networkLayer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IdleState getIdleState() {
		if(null == idle) {
			idle = new IdleState(this);
		}
		return idle;
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

	public boolean isCompressionEnabled() {
		return compressionEnabled;
	}

	public void setCompressionEnabled(boolean compressionEnabled) {
		this.compressionEnabled = compressionEnabled;
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

	public CapabilityMode getMode() {
		return mode;
	}

	public void setMode(CapabilityMode mode) {
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

	public boolean isRestartEnabled() {
		return restartEnabled;
	}

	public void setRestartEnabled(boolean restartEnabled) {
		this.restartEnabled = restartEnabled;
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

	public CapabilityInit getCapInit() {
		return capInit;
	}

	public CapabilityMode getCapMode() {
		return capMode;
	}

	public int getMaximumBufferSize() {
		return maximumBufferSize;
	}

	public int getMaximumWindow() {
		return maximumWindow;
	}

	public String getCalledAddresse() {
		return calledAddresse;
	}

	public void setCalledAddresse(String calledAddresse) {
		this.calledAddresse = calledAddresse;
	}

	public String getCallingAddresse() {
		return callingAddresse;
	}

	public void setCallingAddresse(String callingAddresse) {
		this.callingAddresse = callingAddresse;
	}

	public void setSsid(Event<?> ssid) {
		this.ssid = ssid;
	}
	
	public Event<?> getSsid() {
		return ssid;
	}
	
}
