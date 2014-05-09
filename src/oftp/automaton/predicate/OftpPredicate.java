package oftp.automaton.predicate;

import oftp.automaton.OftpAutomaton;
import automaton.predicate.Predicate;

public abstract class OftpPredicate implements Predicate {

	protected OftpAutomaton oftp;

	public OftpPredicate(OftpAutomaton oftp) {
		super();
		this.oftp = oftp;
	}
}
