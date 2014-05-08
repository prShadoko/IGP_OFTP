package automaton.event.network;

import automaton.event.Field;

public class NetworkField<T> extends Field<T> {

	private int length;

	public NetworkField(String name, int length) {
		super(name);
		this.length = length;
	}

	public NetworkField(String name, int length, T expectedValue) {
		super(name, expectedValue);
		this.length = length;
	}

	public int getLength() {
		return length;
	}
}
