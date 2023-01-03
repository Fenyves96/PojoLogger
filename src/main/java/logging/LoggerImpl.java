package logging;

import logging.enums.LogLevel;
import logging.exception.InvalidJsonException;
import logging.exception.InvalidJsonKeyException;
import org.json.JSONException;
import org.json.JSONObject;

public class LoggerImpl implements Logger {
    String outPutFile;
    LogLevel logLevel;
    @Override
    public void setOutputFile(String outPutFileNameInJson) {
        outPutFile = parseStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile");
        System.out.println(outPutFile);
    }

    @Override
    public void setLogLevel(String logLevelInJson) {
        logLevel = parseLogLevelFromJson(logLevelInJson);
    }

    @Override
    public void addLog(String logInJson) {

    }

    private String parseStringValueFromJsonStringByKey(String jsonString, String key) {
        String result;
        JSONObject jsonObject = tryParse(jsonString);
        result = getStringValue(jsonObject, key);
        return result;
    }

    private String getStringValue(JSONObject outPutFileJson, String key) {
        String result;
        try {
            result = outPutFileJson.getString(key);
        } catch (JSONException e) {
            throw new InvalidJsonKeyException();
        }
        return result;
    }

    private JSONObject tryParse(String outPutFileNameInJson) {
        JSONObject result;
        try {
            result = new JSONObject(outPutFileNameInJson);
        } catch (JSONException e) {
            throw new InvalidJsonException();
        }
        return result;
    }

    private LogLevel parseLogLevelFromJson(String logLevelInJson) {
        String logLevelString = parseStringValueFromJsonStringByKey(logLevelInJson, "logLevel");
        return convertStringToLogLevel(logLevelString);
    }

    private LogLevel convertStringToLogLevel(String logLevelString) {
        LogLevel result = null;
        switch (logLevelString) {
            case "debug" -> result = LogLevel.DEBUG;
            case "info" -> result = LogLevel.INFO;
            case "warning" -> result = LogLevel.WARNING;
            case "error" -> result = LogLevel.ERROR;
        }
        return result;
    }
}
