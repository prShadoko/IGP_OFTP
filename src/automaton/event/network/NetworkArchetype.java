package automaton.event.network;

import automaton.event.Archetype;

public class NetworkArchetype extends Archetype<NetworkField<?>> {

	public NetworkArchetype(String name) {
		super(name);
	}

	public int getLength() {
		int length = 0;

		for (NetworkField<?> field : getFields()) {
			length += field.getLength();
		}

		return length;
	}
}
