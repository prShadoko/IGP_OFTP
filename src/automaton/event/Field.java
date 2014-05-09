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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expectedValue == null) ? 0 : expectedValue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field<?> other = (Field<?>) obj;
		if (expectedValue == null) {
			if (other.expectedValue != null)
				return false;
		} else if (!expectedValue.equals(other.expectedValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
