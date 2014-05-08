package automaton.event;



import java.util.LinkedList;
import java.util.List;

public class Archetype<F extends Field<?>> {
	
	private String name;
	private List<F> fields = new LinkedList<>();
	
	public Archetype(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addField(F field) {
		fields.add(field);
	}
	
	public List<F> getFields() {
		return fields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
		Archetype<?> other = (Archetype<?>) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@SuppressWarnings("unchecked")
//	public <F extends Field<?>> LinkedList<F> getFields(Class<F> type) {
//		LinkedList<F> typedFields = new LinkedList<>();
//		for(Field<?> field : fields) {
//			if(field.getClass().isAssignableFrom(type)) {
//				typedFields.add((F)field);
//			}
//		}
//		return typedFields;
//	}

	
}
