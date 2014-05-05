package automaton.event;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEvent implements Event {

	private String name;
	private Map<String, Object> attributes = new HashMap<>();

	public AbstractEvent(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public void setAttribute(String key, Object attribute) {
		attributes.put(key, attribute);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		AbstractEvent other = (AbstractEvent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
