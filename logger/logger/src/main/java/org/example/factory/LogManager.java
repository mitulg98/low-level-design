package org.example.factory;

import org.example.interfaces.LogHandler;
import org.example.model.Level;
import org.example.model.LogPublisher;
import org.example.model.logHandlers.*;
import org.example.model.subscribers.ConsoleLogSubscriber;
import org.example.model.subscribers.FileLogSubscriber;

import java.text.SimpleDateFormat;

public class LogManager {
    public static LogHandler getLogHandlerChain() {
        AbstractLogHandler fatalLogHandler = new FatalLogHandler(null);
        AbstractLogHandler errorLogHandler = new ErrorLogHandler(fatalLogHandler);
        AbstractLogHandler warnLogHandler = new WarnLogHandler(errorLogHandler);
        AbstractLogHandler infoLogHandler = new InfoLogHandler(warnLogHandler);
        AbstractLogHandler debugLogHandler = new DebugLogHandler(infoLogHandler);

        return debugLogHandler;
    }

    public static LogPublisher createLogPublisher() {
        ConsoleLogSubscriber consoleLogSubscriber = new ConsoleLogSubscriber(new SimpleDateFormat("MM:dd:yyyy-hh:mm:ss"));
        FileLogSubscriber fileLogSubscriber = new FileLogSubscriber("/Users/mitulgupta/Arena/low-level-design/logger/logger/src/main/resources/test.txt",
                new SimpleDateFormat("hh-mm-ss:MM-dd-yyyy"));

        LogPublisher logPublisher = new LogPublisher();
        logPublisher.addSubscriber(consoleLogSubscriber, Level.INFO);
        logPublisher.addSubscriber(fileLogSubscriber, Level.ERROR);

        return logPublisher;
    }
}
