package oftp.automaton.network;

public class Network {

	public static final int LISTEN_PORT = 101010;
	
	public static final char EOT = 4;
	public static final char CR = 13;
	

	public static String formatString(String str, int length, char leftPad) {
		str = str.substring(0, length);
		return String.format("%" + length + "s", "").replace(' ', leftPad).substring(str.length()) + str;
	}
}
