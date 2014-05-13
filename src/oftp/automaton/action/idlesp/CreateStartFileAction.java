package oftp.automaton.action.idlesp;

import automaton.event.Event;
import automaton.event.network.NetworkEvent;
import automaton.exception.ActionExecutionExeption;
import oftp.automaton.FileFormat;
import oftp.automaton.OftpAutomaton;
import oftp.automaton.action.OftpAction;
import oftp.automaton.archetype.monitor.input.FStartFileRequestArchetype;
import oftp.automaton.archetype.network.StartFileArchetype;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateStartFileAction extends OftpAction {

	public CreateStartFileAction(OftpAutomaton oftp) {
		super(oftp);
	}

	@Override
	public void execute(Event<?> inputEvent) throws ActionExecutionExeption {

		Event<?> event = new NetworkEvent(new StartFileArchetype());

		Date now = new Date();
		FileFormat fileFormat = inputEvent.getAttribute(FStartFileRequestArchetype.RECORD_FORMAT);
		int maximumRecordSize = 0;
		if(fileFormat != FileFormat.TEXT && fileFormat != FileFormat.UNSTRUCTURED_BINARY_FILE) {
			maximumRecordSize = inputEvent.getAttribute(FStartFileRequestArchetype.RECORD_SIZE);
		}

		event.putAttribute(StartFileArchetype.VIRTUAL_FILE_DATA_SET_NAME, inputEvent.getAttribute(FStartFileRequestArchetype.FILE_NAME));
//		event.putAttribute(StartFileArchetype.RESERVED,                   );
		event.putAttribute(StartFileArchetype.VIRTUAL_FILE_DATE_STAMP,    (new SimpleDateFormat("yyMMdd")).format(now));
		event.putAttribute(StartFileArchetype.VIRTUAL_FILE_TIME_STAMP,    (new SimpleDateFormat("HHmmss")).format(now));
//		event.putAttribute(StartFileArchetype.USER_DATA,                  );
		event.putAttribute(StartFileArchetype.DESTINATION,                inputEvent.getAttribute(FStartFileRequestArchetype.DESTINATION));
		event.putAttribute(StartFileArchetype.ORIGINATOR,                 inputEvent.getAttribute(FStartFileRequestArchetype.ORIGINATOR));
		event.putAttribute(StartFileArchetype.FILE_FORMAT,                fileFormat);
		event.putAttribute(StartFileArchetype.MAXIMUM_RECORD_SIZE,        maximumRecordSize);
		event.putAttribute(StartFileArchetype.FILE_SIZE,                  inputEvent.getAttribute(FStartFileRequestArchetype.FILE_SIZE));
		event.putAttribute(StartFileArchetype.RESTART_POSITION,           inputEvent.getAttribute(FStartFileRequestArchetype.RESTART_POSITION));

		oftp.addOutputEvent(event);
		oftp.setRestartPosition(inputEvent.getAttribute(FStartFileRequestArchetype.RESTART_POSITION));
	}
}
