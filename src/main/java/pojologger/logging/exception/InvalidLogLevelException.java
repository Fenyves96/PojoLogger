package pojologger.logging.exception;

import pojologger.exception.PojoLoggerException;

public class InvalidLogLevelException extends PojoLoggerException {
    public String getMessage(){
        return "Invalid log level!";
    }
}
