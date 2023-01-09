package pojologger.logging;

import pojologger.logging.enums.LogLevel;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

public class Log {
    private LogLevel level;
    private String message;
    private int processId;

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }


    public LogLevel getLevel () {return level;}

    @Override
    public String toString(){
        return MessageFormat.format("{0}|{1}|{2}|{3}",
                level, Calendar.getInstance(TimeZone.getDefault()).getTime(),
                Objects.toString(processId, ""), message);
    }
}
