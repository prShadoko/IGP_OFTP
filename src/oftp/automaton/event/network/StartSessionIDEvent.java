package oftp.automaton.event.network;

import oftp.automaton.network.Network;

public class StartSessionIDEvent extends NetworkEvent {

	public static final String NAME = "SSID";

	public static final char COMMAND_CODE = 'X';
	public static final char LEVEL = '1';
	private String id;
	private String password;
	private int exchangeBufferSize;
	private char sendReceiveCapability;
	public static final char COMPRESSION_INDICATION = 'N';
	public static final char RESTART_INDICATION = 'N';
	public static final char SPECIAL_LOGIC_INDICATION = 'N';
	private int credit;
	private String reserved;
	private String userData;

	public StartSessionIDEvent(String name) {
		super(NAME);
	}

	@Override
	public byte[] toBytes() {
		StringBuilder builder = new StringBuilder();

		builder.append(COMMAND_CODE);
		builder.append(LEVEL);
		builder.append(Network.formatString(id, 25, ' '));
		builder.append(Network.formatString(password, 8, ' '));
		builder.append(Network.formatString(String.valueOf(exchangeBufferSize), 5, '0'));
		builder.append(sendReceiveCapability);
		builder.append(COMPRESSION_INDICATION);
		builder.append(RESTART_INDICATION);
		builder.append(SPECIAL_LOGIC_INDICATION);
		builder.append(Network.formatString(String.valueOf(credit), 3, '0'));
		builder.append(Network.formatString(reserved, 5, ' '));
		builder.append(Network.formatString(userData, 8, ' '));
		builder.append(Network.CR);

		return builder.toString().getBytes();
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setExchangeBufferSize(int exchangeBufferSize) {
		this.exchangeBufferSize = exchangeBufferSize;
	}

	public void setSendReceiveCapabilitie(char sendReceiveCapability) {
		this.sendReceiveCapability = sendReceiveCapability;
	}

	public void setUserData(int credit) {
		this.credit = credit;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getSendReceiveCapability() {
		return sendReceiveCapability;
	}

	public void setSendReceiveCapability(char sendReceiveCapability) {
		this.sendReceiveCapability = sendReceiveCapability;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getPassword() {
		return password;
	}

	public int getExchangeBufferSize() {
		return exchangeBufferSize;
	}

	public String getReserved() {
		return reserved;
	}

	public String getUserData() {
		return userData;
	}
}
