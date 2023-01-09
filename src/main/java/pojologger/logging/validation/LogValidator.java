package pojologger.logging.validation;

import org.apache.commons.lang.StringUtils;
import pojologger.logging.LogParser;
import pojologger.logging.enums.LogLevel;
import pojologger.logging.exception.*;
public class LogValidator {
    LogParser logParser = new LogParser();

    public void validateOutPutFileNameJson(String outPutFileNameInJson) {
        String fileName = logParser.parseStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile");
        if (StringUtils.isEmpty(fileName))
            throw new InvalidFileNameException();
    }

    public void validateLogLevelInJson(String logLevelInJson) {
        try {
            logParser.parseLogLevelFromJson(logLevelInJson);
        } catch (Exception ex) {
            throw new InvalidLogLevelException();
        }
    }

    public void validateProcessId(String logInJson) {
        Integer processId;
        try {
            processId = logParser.parseIntValueFromJsonStringByKey(logInJson, "processId");
        } catch (Exception exception) {
            throw new InvalidProcessIdException();
        }
        if (processId == null || processId < 0)
            throw new InvalidProcessIdException();
    }

    public void validateMessage(String logInJson) {
        String message = logParser.parseStringValueFromJsonStringByKey(logInJson, "message");
        if (StringUtils.isEmpty(message))
            throw new InvalidMessageException();
    }

    public void validateLogLevel(LogLevel logLevel) {
        if (logLevel == null)
            throw new MissingParameterException("level");
    }

    public void validateOutPutFile(String outPutFile) {
        if (StringUtils.isEmpty(outPutFile))
            throw new MissingParameterException("outputFile");
    }
}
