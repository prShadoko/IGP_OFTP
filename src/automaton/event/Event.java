package automaton.event;


public interface Event<A extends Archetype<?>> {
	
	<T> T getAttribute(Field<T> field);
	
	void putAttribute(Field<?> field, Object attr);
	
	A getArchetype();
}
