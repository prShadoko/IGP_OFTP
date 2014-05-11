package oftp.automaton;

public enum PlusMinus {

	PLUS('+'),
	MINUS('-');

	private char pm;

	private PlusMinus(char pm) {
		this.pm = pm;
	}

	public String toString() {
		return pm + "";
	}
}
