//package oftp.automaton.event.network;
//
//import automaton.event.network.NetworkEvent;
//
//
//
//public class OFTPNetworkEvent extends NetworkEvent {
//
//	public OFTPNetworkEvent(String name, char commandCode) {
//		super(name);
//
//		addField(OFTPNetworkField.CMD);
//		setAttribute(OFTPNetworkField.CMD.getName(), commandCode);
//	}
//
//	public char getCommandCode() {
//		return (char) getAttribute(OFTPNetworkField.CMD.getName());
//	}
//
//}
