package oftp.automaton.event.network.field;

import java.util.HashMap;
import java.util.Map;

public class AnswerReasonFactory {

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

	private Map<Integer, AnswerReason> reasons = new HashMap<>();

	public AnswerReasonFactory() {
		reasons.put(INVALID_FILENAME.getCode(), 				   INVALID_FILENAME);
		reasons.put(INVALID_DESTINATION.getCode(), 				   INVALID_DESTINATION);
		reasons.put(INVALID_ORIGIN.getCode(), 					   INVALID_ORIGIN);
		reasons.put(STORAGE_RECORD_FORMAT_NOT_SUPPORTED.getCode(), STORAGE_RECORD_FORMAT_NOT_SUPPORTED);
		reasons.put(MAXIMUM_RECORD_LENGTH_NOT_SUPPORTED.getCode(), MAXIMUM_RECORD_LENGTH_NOT_SUPPORTED);
		reasons.put(FILE_SIZE_TOO_BIG.getCode(), 				   FILE_SIZE_TOO_BIG);
		reasons.put(INVALID_RECORD_COUNT.getCode(), 			   INVALID_RECORD_COUNT);
		reasons.put(INVALID_BYTE_COUNT.getCode(), 				   INVALID_BYTE_COUNT);
		reasons.put(ACCESS_METHOD_FAILURE.getCode(), 			   ACCESS_METHOD_FAILURE);
		reasons.put(DUPLICATE_FILE.getCode(), 					   DUPLICATE_FILE);
		reasons.put(UNSPECIFIED_REASON.getCode(), 				   UNSPECIFIED_REASON);
	}

	public AnswerReason build(int answerCode) {
		return reasons.get(answerCode);
	}
}
