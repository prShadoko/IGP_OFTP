package automaton.exception;

public class ActionExecutionException extends AutomatonException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1982097224890940185L;

	public ActionExecutionException() {
		super();
	}

	public ActionExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActionExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionExecutionException(String message) {
		super(message);
	}

	public ActionExecutionException(Throwable cause) {
		super(cause);
	}

}
