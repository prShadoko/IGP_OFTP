package automaton.event.network;

public class NetworkField<T> {

	private String name;
	private int length;
	private T expectedValue;

	public NetworkField(String name, int length) {
		super();
		this.name = name;
		this.length = length;
	}

	public NetworkField(String name, int length, T expectedValue) {
		super();
		this.name = name;
		this.length = length;
		this.expectedValue = expectedValue;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}
	
	public T getExpectedValue() {
		return expectedValue;
	}
	
	public boolean hasExpectedValue() {
		return (null == expectedValue) ? false : true;
	}
}
