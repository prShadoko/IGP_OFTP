package oftp.automaton;

public enum CapabilityInit {

	INITIATOR('I'),
	RESPONDER('R'),
	BOTH('B');

	private char mode;
	
	private CapabilityInit(char mode) {
		this.mode = mode;
	}
	
	public String toString() {
		return mode + "";
	}
}
