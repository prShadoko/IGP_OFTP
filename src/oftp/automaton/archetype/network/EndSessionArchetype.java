package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import oftp.automaton.EndSessionAnswerReason;
import oftp.automaton.network.OftpNetworkField;

public class EndSessionArchetype extends AnswerReasonArchetype {

	public static final String NAME = "ESID";
	
//	public static final NetworkField<AnswerReason> REASON_CODE = new NetworkField<>("ESIDREAS", 2);

	public EndSessionArchetype(int expectedReasonCode) {
		super(NAME, CommandCode.ESID, new EndSessionAnswerReason());
		
		addField(buildAnswerReasonField("ESIDREAS", 2, expectedReasonCode));
		addField(OftpNetworkField.CR);
	}
}
