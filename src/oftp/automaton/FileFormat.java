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

	public char toChar() {
		return format;
	}

	public String toString() {
		return format + "";
	}
	
	public static FileFormat fromChar(char c) {
		for(FileFormat f : values()) {
			if(c == f.toChar()) {
				return f;
			}
		}
		return null;
	}
}
