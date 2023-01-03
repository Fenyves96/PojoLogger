package logging.enums;

import org.apache.commons.lang.StringUtils;

public enum LogLevel {
    DEBUG, INFO, WARNING, ERROR;

    @Override
    public String toString(){
        return StringUtils.capitalize(this.name().toLowerCase());
    }
}
