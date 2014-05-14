package oftp.automaton.factory;

import oftp.automaton.AnswerReason;

import java.util.HashMap;
import java.util.Map;

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
