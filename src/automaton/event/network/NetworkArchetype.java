package automaton.event.network;

import java.util.LinkedList;

public class NetworkArchetype {
	
	private String name;
	private LinkedList<NetworkField<?>> fields = new LinkedList<>();
	
	public NetworkArchetype(String name) {
		this.name = name;
	}
	
	public void addField(NetworkField<?> field) {
		fields.add(field);
	}
	
	public LinkedList<NetworkField<?>> getFields() {
		return fields;
	}
	
	public int getLength() {
		int length = 0;
		
		for(NetworkField<?> field : fields) {
			length += field.getLength();
		}
		
		return length;
	}
	
	public String getName() {
		return name;
	}
}
