package oftp.automaton.archetype.monitor;

import automaton.event.Field;
import oftp.automaton.FileFormat;

import java.util.Date;

public class FileOpeningInitiationArchetype extends MonitorArchetype {

    public static final Field<String>    FILE_NAME        = new Field<>("file-name");
    public static final Field<Date>    DATE_TIME        = new Field<>("date-time");
    public static final Field<String>    DESTINATION      = new Field<>("destination");
    public static final Field<String>    ORIGINATOR       = new Field<>("originator");
    public static final Field<FileFormat> RECORD_FORMAT    = new Field<>("rec-format");
    public static final Field<Integer>   RECORD_SIZE      = new Field<>("rec-size");
    public static final Field<Integer>   FILE_SIZE        = new Field<>("file-size");
    public static final Field<Integer>   RESTART_POSITION = new Field<>("restart-pos");
	
	public FileOpeningInitiationArchetype(String name) {
		super(name);
		
		addField(FILE_NAME);
		addField(DATE_TIME);
		addField(DESTINATION);
		addField(ORIGINATOR);
		addField(RECORD_FORMAT);
		addField(RECORD_SIZE);
		addField(FILE_SIZE);
		addField(RESTART_POSITION);
	}

}
