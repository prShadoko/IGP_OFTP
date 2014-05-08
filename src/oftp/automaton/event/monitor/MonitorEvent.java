package oftp.automaton.event.monitor;

import automaton.event.EventImpl;
import automaton.event.Archetype;

public class MonitorEvent extends EventImpl<Archetype<?>> {

	public MonitorEvent(Archetype<?> archetype) {
		super(archetype);
	}

}
