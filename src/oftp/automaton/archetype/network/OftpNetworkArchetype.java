package oftp.automaton.archetype.network;

import oftp.automaton.CommandCode;
import automaton.event.network.NetworkArchetype;
import automaton.event.network.NetworkField;

public class OftpNetworkArchetype extends NetworkArchetype {
	
	private NetworkField<CommandCode> commandCode;
	
	public OftpNetworkArchetype(String name, CommandCode cd) {
		super(name);
		this.commandCode = new NetworkField<CommandCode>(name+"CMD", 1, cd);
		addField(this.commandCode);
	}
	
	public NetworkField<CommandCode> getCommandCode() {
		return this.commandCode;
	}
}
