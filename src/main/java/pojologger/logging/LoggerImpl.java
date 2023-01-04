package pojologger.logging;
public class LoggerImpl implements Logger {
    Log log = new Log();
    LogParser logParser = new LogParser();
    LogFileAppender logFileAppender = new LogFileAppender();

    @Override
    public void setOutputFile(String outPutFileNameInJson) {
        log.setOutPutFile(logParser.parseStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile"));
    }

    @Override
    public void setLogLevel(String logLevelInJson) {
        log.setLevel(logParser.parseLogLevelFromJson(logLevelInJson));
    }

    @Override
    public void addLog(String logInJson) {
        log.setMessage(logParser.parseStringValueFromJsonStringByKey(logInJson, "message"));
        log.setProcessId(logParser.parseIntValueFromJsonStringByKey(logInJson, "processId"));
        logFileAppender.append(log);
    }
}
