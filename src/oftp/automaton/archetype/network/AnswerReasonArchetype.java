package oftp.automaton.archetype.network;

import oftp.automaton.AnswerReason;
import oftp.automaton.CommandCode;
import oftp.automaton.factory.AnswerReasonFactory;
import automaton.event.network.NetworkField;

public abstract class AnswerReasonArchetype extends OftpNetworkArchetype {

	private AnswerReasonFactory factory;

	public AnswerReasonArchetype(String name, CommandCode code, AnswerReasonFactory factory) {
		super(name, code);
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
