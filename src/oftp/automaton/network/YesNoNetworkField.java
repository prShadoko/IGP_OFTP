package oftp.automaton.network;

import automaton.event.network.NetworkField;
import oftp.automaton.YesNo;

public class YesNoNetworkField extends NetworkField<YesNo> {

	public YesNoNetworkField(String name, YesNo expectedValue) {
		super(name, 1, expectedValue);
	}

	public YesNoNetworkField(String name) {
		super(name, 1);
	}

	@Override
	public YesNo fromString(String str) {
		return YesNo.fromChar(str.charAt(0));
	}

	@Override
	public YesNo fromByte(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		builder.append(bytes);
		return fromString(builder.toString());
	}
}
