package oftp.automaton.event.monitor;

import automaton.event.AbstractEvent;
import automaton.event.Archetype;

public class MonitorEvent extends AbstractEvent<Archetype<?>> {

	public MonitorEvent(Archetype<?> archetype) {
		super(archetype);
	}

}
