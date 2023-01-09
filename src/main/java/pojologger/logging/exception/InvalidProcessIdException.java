package pojologger.logging.exception;

import pojologger.exception.PojoLoggerException;

public class InvalidProcessIdException extends PojoLoggerException {
    public String getMessage(){
        return "Invalid processId!";
    }
}
