package automaton.exception;

public class ActionExecutionExeption extends AutomatonException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1982097224890940185L;

	public ActionExecutionExeption() {
		super();
	}

	public ActionExecutionExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActionExecutionExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionExecutionExeption(String message) {
		super(message);
	}

	public ActionExecutionExeption(Throwable cause) {
		super(cause);
	}

}
