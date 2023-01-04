package pojologger.logging;

import pojologger.logging.enums.LogLevel;
import pojologger.logging.exception.InvalidJsonException;
import org.apache.commons.lang.math.NumberUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class LogParser {

    public String parseStringValueFromJsonStringByKey(String jsonString, String key) {
        String result;
        JSONObject jsonObject = tryParse(jsonString);
        result = getStringValue(jsonObject, key);
        return result;
    }

    private String getStringValue(JSONObject jsonString, String key) {
        String result = null;
        try {
            result = jsonString.getString(key);
        } catch (JSONException e) {
            System.out.println("invalid JsonKey");
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

    public LogLevel parseLogLevelFromJson(String logLevelInJson) {
        String logLevelString = parseStringValueFromJsonStringByKey(logLevelInJson, "logLevel");
        return LogLevel.getLevel(logLevelString);
    }

    public int parseIntValueFromJsonStringByKey(String jsonString, String key) {
        String stringValue = parseStringValueFromJsonStringByKey(jsonString, key);
        return NumberUtils.createInteger(stringValue);
    }
}
