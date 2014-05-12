package automaton.tools;

public class NetworkTools {

	public static final char EOT = 4;
	public static final char CR = 13;

	public static String formatString(String str, int length, char leftPad) {
		if (str.length() > length) {
			str = str.substring(0, length);
		}
		return String.format("%" + length + "s", "").replace(' ', leftPad).substring(str.length()) + str;
	}
	
	public static String removeLeftPad(String str, char leftPad) {
		while(' ' == str.charAt(0)) {
			str = str.substring(1);
		}
		
		return str;
	}
}
