package oftp.monitor;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import oftp.automaton.CapabilityInit;
import oftp.automaton.CapabilityMode;
import oftp.automaton.FileFormat;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.archetype.monitor.MonitorEvent;
import oftp.automaton.archetype.monitor.input.FCloseFileRequestArchetype;
import oftp.automaton.archetype.monitor.input.FConnectionRequestArchetype;
import oftp.automaton.archetype.monitor.input.FDataRequestArchetype;
import oftp.automaton.archetype.monitor.input.FStartFileRequestArchetype;
import oftp.automaton.archetype.monitor.output.FAbortIndicationArchetype;
import oftp.automaton.archetype.monitor.output.FConnectionConfirmationArchetype;
import oftp.automaton.archetype.monitor.output.PositiveFStartFileConfirmationArchetype;
import oftp.service.FileService;
import automaton.event.Archetype;
import automaton.event.Event;
import automaton.event.EventLayer;

public class MonitorInitiator extends EventLayer implements Runnable {

	private FileService fileService = new FileService();
	
	private String ip;
	private OftpAutomaton oftp;

	public MonitorInitiator(String ip) {
		this.ip = ip;
	}

	@Override
	public void run() {
		try {
			oftp = OftpAutomaton.build(false, CapabilityInit.BOTH, CapabilityMode.BOTH, 999999, 999);
			this.subscribe(MonitorEvent.class, oftp);
			oftp.subscribe(MonitorEvent.class, this);

			Thread oftpThread = new Thread(oftp);
			oftpThread.start();

			Socket socket = new Socket(ip, MonitorAcceptor.LISTEN_PORT);
			MonitorEvent fConReq = new MonitorEvent(new FConnectionRequestArchetype());
			fConReq.putAttribute(FConnectionRequestArchetype.SOCKET, socket);
			fConReq.putAttribute(FConnectionRequestArchetype.MODE, CapabilityMode.BOTH);
			fConReq.putAttribute(FConnectionRequestArchetype.RESTART, false);

			publish(fConReq);

			oftpThread.join();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MonitorInitiator monitor = new MonitorInitiator("localhost");
		monitor.run();
	}

	@Override
	public void inform(Event<?> inputEvent) {
		System.out.println(inputEvent);
		Archetype<?> archetype = inputEvent.getArchetype();
		Event<?> event = null;
		if (archetype.equals(new FAbortIndicationArchetype())) {
			System.out.println("Monitor: ABORT");
			System.out.println("Monitor: Reason=" + inputEvent.getAttribute(FAbortIndicationArchetype.REASON));
			oftp.closeNetworkLayer();
		} else if (archetype.equals(new FConnectionConfirmationArchetype())) {
			Date now = new Date();

			event = new MonitorEvent(new FStartFileRequestArchetype());
			event.putAttribute(FStartFileRequestArchetype.DATE_TIME, now);
			event.putAttribute(FStartFileRequestArchetype.DESTINATION, "/img");
			event.putAttribute(FStartFileRequestArchetype.FILE_NAME, "flowerS");
			event.putAttribute(FStartFileRequestArchetype.FILE_SIZE, (int) fileService.getFileSize());
			event.putAttribute(FStartFileRequestArchetype.ORIGINATOR, "MonitorInitiator");
			event.putAttribute(FStartFileRequestArchetype.RECORD_FORMAT, FileFormat.UNSTRUCTURED_BINARY_FILE);
			event.putAttribute(FStartFileRequestArchetype.RECORD_SIZE, 0);
			event.putAttribute(FStartFileRequestArchetype.RESTART_POSITION, 0);
		}else if (archetype.equals(new PositiveFStartFileConfirmationArchetype())) {
			byte[] buff = new byte[oftp.getBufferSize()];
			int recordCount = 0;
			int unitCount = 0;
			int result = -1;
			do {
				result = fileService.getByte(buff);

				event = new MonitorEvent(new FDataRequestArchetype());
				event.putAttribute(FDataRequestArchetype.F_DATA, buff);

				publish(event);
				recordCount++;
				if(-1 != result) {
					unitCount += result;
				}
			} while(-1 != result);
			
			event = new MonitorEvent(new FCloseFileRequestArchetype());
			event.putAttribute(FCloseFileRequestArchetype.RECORD_COUNT, recordCount);
			event.putAttribute(FCloseFileRequestArchetype.UNIT_COUNT, unitCount);
		}

		if (null != event) {
			publish(event);
		}
		

	}
}
