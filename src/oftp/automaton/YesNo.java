package oftp.automaton;

public enum YesNo {

	YES('Y', true),
	NO('N', false);

	public static final YesNo fromBoolean(boolean b) {
		return b ? YesNo.YES : YesNo.NO;
	}
	
	public static final YesNo fromChar(char c) {
		return c == 'Y' ? YesNo.YES : YesNo.NO;
	}

	private char yn;
	private boolean b;

	private YesNo(char yn, boolean b) {
		this.yn = yn;
		this.b = b;
	}

	public String toString() {
		return yn + "";
	}
	
	public char toChar() {
		return yn;
	}
	
	public boolean toBoolean() {
		return b;
	}
}
