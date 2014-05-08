package automaton.event;

import java.util.HashMap;
import java.util.Map;

public class EventImpl<A extends Archetype<?>> implements Event<A> {

	private A archetype;
	private Map<Field<?>, Object> attributes = new HashMap<>();

	public EventImpl(A archetype) {
		setArchetype(archetype);
		init();
	}

	private void init() {
		for (Field<?> field : getArchetype().getFields()) {
			if (field.hasExpectedValue()) {
				this.putAttribute(field, field.getExpectedValue());
			}
		}
	}

	@Override
	public A getArchetype() {
		return archetype;
	}

	public void setArchetype(A archetype) {
		this.archetype = archetype;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(Field<T> field) {
		return (T) attributes.get(field);
	}

	@Override
	public void putAttribute(Field<?> field, Object attr) {
		attributes.put(field, attr);
	}
	
	@Override
	public String toString() {
		return archetype.getName();
	}
}
