package automaton.event.network;

import automaton.event.AbstractEvent;
import automaton.event.Field;
import automaton.tools.NetworkTools;

public class NetworkEvent extends AbstractEvent<NetworkArchetype> {

	public static final NetworkField<byte[]> TO_BYTES = new NetworkField<>("toBytes", 0);

	public NetworkEvent(NetworkArchetype archetype) {
		super(archetype);
	}

	@Override
	public <T> T getAttribute(Field<T> field) {

		if (TO_BYTES.equals(field)) {
			putAttribute(field, this.toBytes());
		}

		return super.getAttribute(field);
	}

	public byte[] toBytes() {
		StringBuilder bytes = new StringBuilder();

		for (NetworkField<?> field : getArchetype().getFields()) {

			Object attribute = getAttribute(field);
			String attributeStr = "";
			if (null != attribute) {
				attributeStr = attribute.toString();
			}
			bytes.append(NetworkTools.formatString(attributeStr, field.getLength(), ' '));
		}

		return bytes.toString().getBytes();
	}

}
