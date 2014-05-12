package oftp.automaton;

public enum CapabilityMode {

	SENDER_ONLY('S'),
	RECEIVER_ONLY('R'),
	BOTH('B');

	private char mode;
	
	private CapabilityMode(char mode) {
		this.mode = mode;
	}

	public String toString() {
		return mode + "";
	}
	
	public char toChar() {
		return mode;
	}

	public static CapabilityMode fromChar(char c) {
		for(CapabilityMode mode : values()) {
			if(c == mode.toChar()) {
				return mode;
			}
		}
		return null;
	}
}
