package org.example;

import logging.Logger;
import logging.LoggerImpl;

public class Main {
    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        logger.setOutputFile("""
                {"outPutFile" : "log1.txt"}
                """
        );
        logger.setLogLevel("""
        {"logLevel" : "warning"}
        """);
        logger.addLog("""
                {
                "processId" : 123456,
                "message" : "File Not Found"
                }
                """);
    }
}