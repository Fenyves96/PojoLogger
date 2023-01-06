package pojologger.logging.exception;

import pojologger.exception.PojoLoggerException;

public class InvalidFileNameException extends PojoLoggerException {
    public String getMessage(){
        return "Invalid filename!";
    }
}
