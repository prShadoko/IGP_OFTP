package oftp.automaton.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import pattern.publish.subscribe.Publisher;
import pattern.publish.subscribe.Subscriber;
import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.tools.NetworkTools;

public class NetworkLayer extends Publisher<Event> implements Runnable, Subscriber<Event> {

	private Socket socket;
	private OFTPNetworkEventFactory eventFactory;

	private OutputStream out;

	public NetworkLayer(Socket socket, OFTPNetworkEventFactory eventFactory) {
		this.socket = socket;
		this.eventFactory = eventFactory;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			out = socket.getOutputStream();

			while (!socket.isClosed()) {
				StringBuilder packet = new StringBuilder();

				int read = in.read();
				if(-1 == read) {
					close();
				} else {
					while (NetworkTools.EOT != read && -1 != read) {
						packet.append((char) read);
						read = in.read();
					}
					
					NetworkEvent event = eventFactory.build(packet.toString());
					if (null != event) {
						publish(event);
					}
				}
			}

		} catch (IOException e) {
			// TODO Do publish error event ?
			e.printStackTrace();
		}
	}

	@Override
	public void inform(final Event event) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				send(event);
			}
		}).start();
	}

	public void send(Event event) {
		try {
			out.write((byte[]) event.getAttribute(NetworkEvent.TO_BYTES));
			out.write(NetworkTools.EOT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		socket.close();
	}
}
