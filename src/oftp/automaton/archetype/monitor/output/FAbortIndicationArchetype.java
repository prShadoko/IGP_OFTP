package oftp.automaton.archetype.monitor.output;

import automaton.event.Field;
import oftp.automaton.AbortOrigin;
import oftp.automaton.archetype.monitor.MonitorArchetype;

public class FAbortIndicationArchetype extends MonitorArchetype {

	public static final String NAME = "F_ABORT_IND";

	public static final Field<String> REASON = new Field<>("reason");
	public static final Field<AbortOrigin> ABORT_ORIGIN = new Field<>("abort-origin");

	public FAbortIndicationArchetype() {
		super(NAME);
		
		addField(REASON);
		addField(ABORT_ORIGIN);
	}

}
