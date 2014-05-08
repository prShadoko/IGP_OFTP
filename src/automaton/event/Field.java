package automaton.event;

public class Field<T> {

	private String name;
	private T expectedValue;

	public Field(String name) {
		this.name = name;
	}
	
	public Field(String name, T expectedValue) {
		this.name = name;
		this.expectedValue = expectedValue;
	}
	
	public String getName() {
		return name;
	}
	
	public T getExpectedValue() {
		return expectedValue;
	}
	
	public boolean hasExpectedValue() {
		return (null == expectedValue) ? false : true;
	}
}
