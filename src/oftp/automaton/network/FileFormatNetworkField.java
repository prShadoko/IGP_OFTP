package oftp.automaton.network;

import oftp.automaton.FileFormat;
import automaton.event.network.NetworkField;

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
	
	@Override
	public FileFormat fromByte(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		builder.append(bytes);
		return fromString(builder.toString());
	}
}
