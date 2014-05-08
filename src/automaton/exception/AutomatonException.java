package automaton.exception;

public class AutomatonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6546831340408527187L;

	public AutomatonException() {
		super();
	}

	public AutomatonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AutomatonException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutomatonException(String message) {
		super(message);
	}

	public AutomatonException(Throwable cause) {
		super(cause);
	}

}
