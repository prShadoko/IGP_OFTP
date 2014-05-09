package oftp.automaton.event.network.field.factory;

import java.util.HashMap;
import java.util.Map;

import oftp.automaton.event.network.field.AnswerReason;

public class AnswerReasonFactory {

	private Map<Integer, AnswerReason> reasons = new HashMap<>();

	public AnswerReasonFactory() {
	
	}
	
	public void addReason(AnswerReason reason) {
		reasons.put(reason.getCode(), reason);
	}

	public AnswerReason build(int answerCode) {
		return reasons.get(answerCode);
	}
}
