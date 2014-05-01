package oftp.automaton.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import oftp.automaton.event.network.NetworkEvent;
import pattern.publish.subscribe.Publisher;
import pattern.publish.subscribe.Subscriber;
import automaton.event.Event;

public class NetworkLayer extends Publisher<Event> implements Runnable, Subscriber<Event> {

	private Socket socket;
	private NetworkEventFactory eventFactory;
	
	private OutputStream out;

	public NetworkLayer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			out = socket.getOutputStream();

			while (!socket.isClosed()) {
				ArrayList<Integer> packet = new ArrayList<>();

				int read = in.read();
				while (Network.EOT != read && -1 == read) {
					packet.add(read);
					read = in.read();
				}

				 NetworkEvent event = eventFactory.build(packet);
				 publish(event);
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
			out.write((byte[]) event.getAttribute("toByte"));
			out.write(Network.EOT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() throws IOException {
		socket.close();
	}
}
