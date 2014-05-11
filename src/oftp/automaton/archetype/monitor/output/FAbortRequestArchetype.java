package oftp.automaton.archetype.monitor.output;

import oftp.automaton.AbortOrigin;
import oftp.automaton.archetype.monitor.MonitorArchetype;
import automaton.event.Field;

public class FAbortRequestArchetype extends MonitorArchetype {

	public static final String NAME = "F_ABORT_RQ";

	public static final Field<String> REASON = new Field<>("reason");
	public static final Field<AbortOrigin> ABORT_ORIGIN = new Field<>("abort-origin");
	
	public FAbortRequestArchetype() {
		super(NAME);
		
		addField(REASON);
		addField(ABORT_ORIGIN);
	}

}
