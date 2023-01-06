package pojologger.logging;

import pojologger.logging.enums.LogLevel;
import pojologger.logging.validation.LogValidator;

public class LoggerImpl implements Logger {
    Log log = new Log();
    LogParser logParser = new LogParser();
    LogFileAppender logFileAppender = new LogFileAppender();

    LogValidator validator = new LogValidator();

    @Override
    public void setOutputFile(String outPutFileNameInJson) {
        validator.validateOutPutFileNameJson(outPutFileNameInJson);
        String fileName = logParser.parseStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile");
        log.setOutPutFile(fileName);
    }

    @Override
    public void setLogLevel(String logLevelInJson) {
        validator.validateLogLevelInJson(logLevelInJson);
        LogLevel level = logParser.parseLogLevelFromJson(logLevelInJson);
        log.setLevel(level);
    }

    @Override
    public void addLog(String logInJson) {
        validator.validateOutPutFileAndLogLevelNotEmpty(log);
        validator.validateProcessId(logInJson);
        validator.validateMessage(logInJson);

        String message = logParser.parseStringValueFromJsonStringByKey(logInJson, "message");
        int processId = logParser.parseIntValueFromJsonStringByKey(logInJson, "processId");
        log.setMessage(message);
        log.setProcessId(processId);
        logFileAppender.append(log);
    }
}
