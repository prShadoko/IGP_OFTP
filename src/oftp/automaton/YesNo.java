package oftp.automaton;

public enum YesNo {

	YES('Y'),
	NO('N');

	private char yn;

	private YesNo(char yn) {
		this.yn = yn;
	}

	public String toString() {
		return yn + "";
	}
}
