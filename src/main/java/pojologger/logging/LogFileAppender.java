package pojologger.logging;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LogFileAppender {
    private String outPutFile;

    public String getOutPutFile() {
        return outPutFile;
    }

    public void setOutPutFile(String outPutFile) {
        this.outPutFile = outPutFile;
    }
    public void append(Log log) {
        writeToFile(log);
    }

    private void writeToFile(Log log) {
        try {
            FileUtils.writeStringToFile(new File(outPutFile), log + "\n", StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
