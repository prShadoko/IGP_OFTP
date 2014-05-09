package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.factory.AnswerReasonFactory;
import automaton.event.network.NetworkField;

public abstract class AnswerReasonArchetype extends OftpNetworkArchetype {

	private AnswerReasonFactory factory;

	public AnswerReasonArchetype(String name, char commandCode, AnswerReasonFactory factory) {
		super(name, commandCode);
		this.factory = factory;
	}

	public AnswerReasonFactory getAnswerReasonFactory() {
		return factory;
	}
	
	public NetworkField<AnswerReason> buildAnswerReasonField(String name, int length, int expectedReasonCode) {
		AnswerReason expected = factory.build(expectedReasonCode);
		return new NetworkField<>(name, length, expected);
	}
}
