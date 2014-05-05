package oftp.automaton.event.network.archetype;

import automaton.event.network.NetworkArchetype;
import automaton.event.network.NetworkField;

public class OFTPNetworkArchetype extends NetworkArchetype {
	
	private NetworkField<Character> commandCode;
	
	public OFTPNetworkArchetype(String name, char commandCode) {
		super(name);
		this.commandCode = new NetworkField<Character>(name+"CMD", 1, commandCode);
		addField(this.commandCode);
	}
	
	public NetworkField<Character> getCommandCode() {
		return this.commandCode;
	}
}
