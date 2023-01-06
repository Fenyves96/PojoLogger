package pojologger.logging.exception;

import pojologger.exception.PojoLoggerException;

import java.util.List;

public class MissingParametersException extends PojoLoggerException {
    List<String> missingParameters;
    public MissingParametersException(List<String> missingParameters) {
        this.missingParameters = missingParameters;
    }

    @Override
    public String getMessage(){
        return String.join(",", missingParameters) + " missing!";
    }
}
