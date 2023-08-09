package org.example.model;

import org.example.interfaces.LogHandler;

import static org.example.factory.LogManager.createLogPublisher;
import static org.example.factory.LogManager.getLogHandlerChain;

public class Logger {
    private static volatile Logger logger;
    private static LogHandler logHandler;

    private static LogPublisher logPublisher;

    private Logger() {
    }

    public static Logger getInstance() {
        if(logger == null) {
            synchronized(Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                    logHandler = getLogHandlerChain();
                    logPublisher = createLogPublisher();
                }
            }
        }

        return logger;
    }

    public void info(String content, String nameSpace) {
        logHandler.handleLog(new Message(content, Level.INFO, nameSpace), logPublisher);
    }

    public void debug(String content, String nameSpace) {
        logHandler.handleLog(new Message(content, Level.DEBUG, nameSpace), logPublisher);
    }

    public void warn(String content, String nameSpace) {
        logHandler.handleLog(new Message(content, Level.WARN, nameSpace), logPublisher);
    }

    public void error(String content, String nameSpace) {
        logHandler.handleLog(new Message(content, Level.ERROR, nameSpace), logPublisher);
    }

    public void fatal(String content, String nameSpace) {
        logHandler.handleLog(new Message(content, Level.FATAL, nameSpace), logPublisher);
    }
}
