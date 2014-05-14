package oftp.automaton.predicate;

import automaton.predicate.Predicate;
import oftp.automaton.OftpAutomaton;

public abstract class OftpPredicate implements Predicate {

	protected OftpAutomaton oftp;

	public OftpPredicate(OftpAutomaton oftp) {
		this.oftp = oftp;
	}
}
