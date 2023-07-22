package org.example;

import org.example.model.*;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSZ");
        Configuration configuration = new Configuration(dateFormat, Level.INFO, SinkType.CONSOLE, "");
        loggingSystem.addConfiguration(configuration);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Configuration configuration1 = new Configuration(simpleDateFormat, Level.WARN, SinkType.FILE,
                "/Users/mitulgupta/Arena/logger/logger/src/main/resources/test.txt");
        loggingSystem.addConfiguration(configuration1);

        Message m1 = new Message("New servie started", Level.INFO, "application123");
        Message m2 = new Message("Warning changes overriden", Level.WARN, "application124");
        Message m3 = new Message("Validation Exception : com.successfactors", Level.ERROR, "application125");
        Message m4 = new Message("Fatal: Catalina stopped", Level.FATAL, "application134");
        loggingSystem.logMessage(m3);
        loggingSystem.logMessage(m1);
        loggingSystem.logMessage(m2);
        loggingSystem.logMessage(m4);
    }
}