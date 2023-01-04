package pojologger.logging.enums;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;

public enum LogLevel {
    DEBUG, INFO, WARNING, ERROR;

    @Override
    public String toString(){
        return StringUtils.capitalize(this.name().toLowerCase());
    }

    public  static LogLevel getLevel(String value){
        Objects.requireNonNull(value);
        return LogLevel.valueOf(value.toUpperCase());
    }
}
