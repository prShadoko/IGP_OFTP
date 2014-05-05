package oftp.automaton.event.network;

import automaton.event.network.NetworkField;
import automaton.tools.NetworkTools;

public class OFTPNetworkField {

	public static final NetworkField<Character> CMD = new NetworkField<>("CMD", 1);
	public static final NetworkField<Character> CR = new NetworkField<>("CR", 1, NetworkTools.CR);
}
