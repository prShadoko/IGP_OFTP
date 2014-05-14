package oftp.automaton.network;

import automaton.event.Event;
import automaton.event.EventLayer;
import automaton.event.network.NetworkEvent;
import automaton.tools.NetworkTools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkLayer extends EventLayer implements Runnable {

	private Socket socket;
	private OftpNetworkEventFactory eventFactory;

	private OutputStream out;

	public NetworkLayer(Socket socket, OftpNetworkEventFactory eventFactory) {
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
				if (-1 == read) {
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
			System.out.println("Socket may be closed.");
			e.printStackTrace();
		}
	}

	@Override
	public void inform(final Event<?> event) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					send(event);
				} catch (IOException e) {
					System.out.println("Socket may be closed.");
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void send(Event<?> event) throws IOException {
		out.write(event.getAttribute(NetworkEvent.TO_BYTES));
		out.write(NetworkTools.EOT);
	}

	public void close() throws IOException {
		socket.close();
	}
}
