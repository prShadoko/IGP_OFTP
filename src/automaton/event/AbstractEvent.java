package automaton.event;

public abstract class AbstractEvent implements Event {

	private String name;

	public AbstractEvent(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

}
