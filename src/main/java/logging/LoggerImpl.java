package logging;

import logging.exception.InvalidJsonException;
import logging.exception.InvalidJsonKeyException;
import org.json.JSONException;
import org.json.JSONObject;

public class LoggerImpl implements Logger {
    String outPutFile;
    @Override
    public void setOutputFile(String outPutFileNameInJson) {
        outPutFile = getStringValueFromJsonStringByKey(outPutFileNameInJson, "outPutFile");
        System.out.println(outPutFile);
    }

    @Override
    public void setLogLevel(String logLevelInJson) {

    }

    @Override
    public void addLog(String logInJson) {

    }

    private String getStringValueFromJsonStringByKey(String jsonString, String key) {
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
}
