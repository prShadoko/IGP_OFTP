package oftp.automaton.network;

import automaton.event.network.NetworkField;
import oftp.automaton.CapabilityMode;

public class ModeNetworkField extends NetworkField<CapabilityMode> {

	public ModeNetworkField(String name) {
		super(name, 1);
	}

	public ModeNetworkField(String name, CapabilityMode expectedValue) {
		super(name, 1, expectedValue);
	}
	
	@Override
	public CapabilityMode fromString(String str) {
		return CapabilityMode.fromChar(str.charAt(0));
	}

	@Override
	public CapabilityMode fromByte(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		builder.append(bytes);
		return fromString(builder.toString());
	}
}
