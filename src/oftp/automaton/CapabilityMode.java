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
}
