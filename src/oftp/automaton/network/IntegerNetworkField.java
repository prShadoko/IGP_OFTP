package oftp.automaton.network;

import automaton.event.network.NetworkField;
import automaton.tools.NetworkTools;

public class IntegerNetworkField extends NetworkField<Integer> {

	public IntegerNetworkField(String name, int length, Integer expectedValue) {
		super(name, length, expectedValue);

	}

	public IntegerNetworkField(String name, int length) {
		super(name, length);
	}

	@Override
	public Integer fromString(String str) {
		return Integer.valueOf(NetworkTools.removeLeftPad(str, ' '));
	}
	
	@Override
	public Integer fromByte(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		builder.append(bytes);
		return fromString(builder.toString());
	}
}
