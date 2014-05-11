package oftp.automaton;

public enum FileFormat {
	FIXED_FORMAT_BINARY_FILE('F'),
	VARIABLE_FORMAT_BINARY_FILE('V'),
	UNSTRUCTURED_BINARY_FILE('U'),
	TEXT('T');
	
	private char format;

	private FileFormat(char format) {
		this.format = format;
	}

	public String toString() {
		return format + "";
	}
}