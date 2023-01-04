package logging;

import logging.enums.LogLevel;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

public class LoggerImpl implements Logger {
    String outPutFile;
    LogLevel logLevel;
    LogParser logParser = new LogParser();
    LogFileAppender logFileAppender = new LogFileAppender();

    @Override
    public void setOutputFile(String outPutFileNameInJson) {
        outPutFile = logParser.parseStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile");
    }

    @Override
    public void setLogLevel(String logLevelInJson) {
        logLevel = logParser.parseLogLevelFromJson(logLevelInJson);
    }

    @Override
    public void addLog(String logInJson) {
        String logToSave = generateLogByLogJson(logInJson);
        System.out.println(logToSave);
        logFileAppender.append(outPutFile,logToSave);
    }

    private String generateLogByLogJson(String logInJson) {
        String message = logParser.parseStringValueFromJsonStringByKey(logInJson, "message");
        String processId = logParser.parseStringValueFromJsonStringByKey(logInJson, "processId");
        return MessageFormat.format("{0}|{1}|{2}|{3}",
                logLevel, Calendar.getInstance(TimeZone.getDefault()).getTime(),
                Objects.toString(processId, ""), message);
    }
}
