package pojologger.logging;

public interface Logger {
    void setOutputFile(String outPutFileNameInJson);
    void setLogLevel(String logLevelInJson);
    void addLog(String logInJson);
}
