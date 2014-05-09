package oftp.automaton.event.network.field.factory;

import oftp.automaton.event.network.field.AnswerReason;

public class NegativeAnswerReasonFactory extends AnswerReasonFactory {

    public static final AnswerReason INVALID_FILENAME                    = new AnswerReason(1,  "Invalid filename.");
    public static final AnswerReason INVALID_DESTINATION                 = new AnswerReason(2,  "Invalid destination.");
    public static final AnswerReason INVALID_ORIGIN                      = new AnswerReason(3,  "Invalid origin.");
    public static final AnswerReason STORAGE_RECORD_FORMAT_NOT_SUPPORTED = new AnswerReason(4,  "Storage record format not supported.");
    public static final AnswerReason MAXIMUM_RECORD_LENGTH_NOT_SUPPORTED = new AnswerReason(5,  "Maximum record length not supported.");
    public static final AnswerReason FILE_SIZE_TOO_BIG                   = new AnswerReason(6,  "File size is too big.");
    public static final AnswerReason INVALID_RECORD_COUNT                = new AnswerReason(10, "Invalid record count.");
    public static final AnswerReason INVALID_BYTE_COUNT                  = new AnswerReason(11, "Invalid byte count.");
    public static final AnswerReason ACCESS_METHOD_FAILURE               = new AnswerReason(12, "Access method failure.");
    public static final AnswerReason DUPLICATE_FILE                      = new AnswerReason(13, "Duplicate file.");
    public static final AnswerReason UNSPECIFIED_REASON                  = new AnswerReason(99, "Unspecified reason.");

	public NegativeAnswerReasonFactory() {
		addReason(INVALID_FILENAME);
		addReason(INVALID_DESTINATION);
		addReason(INVALID_ORIGIN);
		addReason(STORAGE_RECORD_FORMAT_NOT_SUPPORTED);
		addReason(MAXIMUM_RECORD_LENGTH_NOT_SUPPORTED);
		addReason(FILE_SIZE_TOO_BIG);
		addReason(INVALID_RECORD_COUNT);
		addReason(INVALID_BYTE_COUNT);
		addReason(ACCESS_METHOD_FAILURE);
		addReason(DUPLICATE_FILE);
		addReason(UNSPECIFIED_REASON);
	}
}
