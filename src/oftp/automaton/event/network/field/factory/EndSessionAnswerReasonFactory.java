package oftp.automaton.event.network.field.factory;

import oftp.automaton.event.network.field.AnswerReason;

public class EndSessionAnswerReasonFactory extends AnswerReasonFactory {

    public static final AnswerReason NORMAL_SESSION_TERMINATED         = new AnswerReason(0, "Normal session termination");
    public static final AnswerReason COMMAND_NOT_RECOGNISED            = new AnswerReason(1, "Command not recognised");
    public static final AnswerReason PROTOCOL_VIOLATION                = new AnswerReason(2, "Protocol violation");
    public static final AnswerReason UNKNOWN_USER_COSE                 = new AnswerReason(3, "User code not known");
    public static final AnswerReason INVALID_PASSWORD                  = new AnswerReason(4, "Invalid password");
    public static final AnswerReason LOCAL_SITE_EMERGENCY_CLOSE_DOWN   = new AnswerReason(5, "Local site emergency close down");
    public static final AnswerReason INVALID_DATA                      = new AnswerReason(6, "Command contained invalid data");
    public static final AnswerReason EXCHANGE_BUFFER_SIZE_ERROR        = new AnswerReason(7, "Exchange Buffer size error");
    public static final AnswerReason RESOURCES_NOT_AVAILABLE           = new AnswerReason(8, "Resources not available");
    public static final AnswerReason TIME_OUT                          = new AnswerReason(9, "Time out");
    public static final AnswerReason MODE_OR_CAPABILITIES_INCOMPATIBLE = new AnswerReason(10, "Mode or capabilities incompatible");
    public static final AnswerReason UNSPECIFIED_ABORT_CODE            = new AnswerReason(99, "Unspecified Abort code");
    
	public EndSessionAnswerReasonFactory() {
		addReason(NORMAL_SESSION_TERMINATED);
		addReason(COMMAND_NOT_RECOGNISED);
		addReason(PROTOCOL_VIOLATION);
		addReason(UNKNOWN_USER_COSE);
		addReason(INVALID_PASSWORD);
		addReason(LOCAL_SITE_EMERGENCY_CLOSE_DOWN);
		addReason(INVALID_DATA);
		addReason(EXCHANGE_BUFFER_SIZE_ERROR);
		addReason(RESOURCES_NOT_AVAILABLE);
		addReason(TIME_OUT);
		addReason(MODE_OR_CAPABILITIES_INCOMPATIBLE);
		addReason(UNSPECIFIED_ABORT_CODE);
	}
	
}
