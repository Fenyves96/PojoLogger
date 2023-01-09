import org.apache.commons.lang.StringUtils;
import pojologger.exception.PojoLoggerException;
import pojologger.logging.Logger;
import pojologger.logging.LoggerImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = new LoggerImpl();
        String command = null;
        while (!"Q".equals(StringUtils.upperCase(command))) {
            System.out.print("Command (F,L,A,Q) (File, Level, ProcessId|Message, quit) : ");
            command = sc.next();
            try {
                switch (StringUtils.upperCase(command)) {
                    case "F" -> setFileName(sc, logger);
                    case "L" -> setLogLevel(sc, logger);
                    case "A" -> addLog(sc, logger);
                }
            }catch (PojoLoggerException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void addLog(Scanner sc, Logger logger) {
        System.out.print("processId|message:");
        String input = sc.next();
        String[] processIdAndMessage = input.split(Pattern.quote("|"));
        String processId = processIdAndMessage[0];
        String message = processIdAndMessage[1];

        logger.addLog("""
                {
                "processId" : %s,
                "message" : "%s"
                }
                """.formatted(processId, message));
    }

    private static void setLogLevel(Scanner sc, Logger logger) {
        System.out.print("log level: ");
        String logLevel = sc.next();
        logger.setLogLevel("""
                {"logLevel" : "%s"}
                """.formatted(logLevel));
    }

    private static void setFileName(Scanner sc, Logger logger) {
        System.out.print("outPutFileName: ");
        String outPutFileName = sc.next();
        logger.setOutputFile("""
                {"outPutFile" : %s}
                """.formatted(outPutFileName));
    }
}