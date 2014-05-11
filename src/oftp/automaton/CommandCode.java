package oftp.automaton;

public enum CommandCode {

	SSRM('I'),
	SSID('X'),
	SFID('H'),
	SFPA('2'),
	SFNA('3'),
	DATA('D'),
	CDT('C'),
	EFID('T'),
	EFPA('4'),
	EFNA('5'),
	ESID('F'),
	CD('R'),
	EERP('E'),
	RTR('P');

	private char code;

	private CommandCode(char code) {
		this.code = code;
	}

	public String toString() {
		return code + "";
	}
}
