package oftp.automaton;


public enum AbortOrigin {
	
	LOCAL("Local"),
	DISTANT("Distant");
	
	private String txt;
	
	private AbortOrigin(String txt) {
		this.txt = txt;
	}
	
	public String toString() {
		return txt;
	}
}
