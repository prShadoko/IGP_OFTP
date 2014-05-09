package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.factory.AnswerReasonFactory;

public class AnswerReasonArchetype extends OFTPNetworkArchetype {

	AnswerReasonFactory factory;
	
	public AnswerReasonArchetype(String name, char commandCode, AnswerReasonFactory factory) {
		super(name, commandCode);
		this.factory = factory;
	}

	public AnswerReasonFactory getAnswerReasonFactory() {
		return factory;
	}
}
