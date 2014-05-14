package oftp.automaton.network;

import automaton.event.network.NetworkField;
import oftp.automaton.FileFormat;

public class FileFormatNetworkField extends NetworkField<FileFormat> {

	public FileFormatNetworkField(String name, FileFormat expectedValue) {
		super(name, 1, expectedValue);
	}

	public FileFormatNetworkField(String name) {
		super(name, 1);
	}

	@Override
	public FileFormat fromString(String str) {

		return FileFormat.fromChar(str.charAt(0));
	}
}
