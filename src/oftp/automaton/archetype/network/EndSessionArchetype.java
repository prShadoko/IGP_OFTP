package oftp.automaton.archetype.network;

import automaton.event.network.NetworkField;
import oftp.automaton.AnswerReason;
import oftp.automaton.CommandCode;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.network.OftpNetworkField;

public class EndSessionArchetype extends AnswerReasonArchetype {

	public static final String NAME = "ESID";
	
	public static final NetworkField<AnswerReason> REASON_CODE = new NetworkField<>("ESIDREAS", 2);

	public EndSessionArchetype() {
		super(NAME, CommandCode.ESID, new EndSessionAnswerReason());
		
		addField(REASON_CODE);
		addField(OftpNetworkField.CR);
	}

	public EndSessionArchetype(int expectedReasonCode) {
		super(NAME, CommandCode.ESID, new EndSessionAnswerReason());
		
		addField(buildAnswerReasonField("ESIDREAS", 2, expectedReasonCode));
		addField(OftpNetworkField.CR);
	}

	public EndSessionArchetype(AnswerReason expectedReason) {
		super(NAME, CommandCode.ESID, null);

		addField(new NetworkField<>("ESIDREAS", 2, expectedReason));
		addField(OftpNetworkField.CR);
	}
}
