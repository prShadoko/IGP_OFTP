package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.OftpNetworkField;
import oftp.automaton.event.network.field.CommandCode;
import oftp.automaton.event.network.field.factory.EndSessionAnswerReasonFactory;

public class EndSessionArchetype extends AnswerReasonArchetype {

	public static final String NAME = "ESID";
	
//	public static final NetworkField<AnswerReason> REASON_CODE = new NetworkField<>("ESIDREAS", 2);

	public EndSessionArchetype(int expectedReasonCode) {
		super(NAME, CommandCode.ESID, new EndSessionAnswerReasonFactory());
		
		addField(buildAnswerReasonField("ESIDREAS", 2, expectedReasonCode));
		addField(OftpNetworkField.CR);
	}
}
