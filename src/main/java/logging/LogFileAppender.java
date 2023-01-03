package logging;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LogFileAppender {
    public void append(String fileName, String log){
        writeToFile(log, new File(fileName));
    }

    private static void writeToFile(String log, File file) {
        try {
            FileUtils.writeStringToFile(file, log + "\n", StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
