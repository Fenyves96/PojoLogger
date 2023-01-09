package pojologger.logging.exception;

import pojologger.exception.PojoLoggerException;

public class MissingParameterException extends PojoLoggerException {
    String missingParameter;
    public MissingParameterException(String missingParameter) {
        this.missingParameter = missingParameter;
    }

    @Override
    public String getMessage(){
        return missingParameter  + " is missing!";
    }
}
