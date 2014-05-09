package oftp.automaton.event.network.archetype;

import oftp.automaton.event.network.OftpNetworkField;
import oftp.automaton.event.network.field.AnswerReason;
import oftp.automaton.event.network.field.CommandCode;
import oftp.automaton.event.network.field.factory.EndSessionAnswerReasonFactory;
import automaton.event.network.NetworkField;

public class EndSessionArchetype extends AnswerReasonArchetype {

	public static final String NAME = "ESID";
	
	public static final NetworkField<AnswerReason> REASON_CODE = new NetworkField<>("ESIDREAS", 2);
	
	public EndSessionArchetype(String name, char commandCode) {
		super(NAME, CommandCode.ESID, new EndSessionAnswerReasonFactory());
		
		addField(REASON_CODE);
		addField(OftpNetworkField.CR);
	}

}
