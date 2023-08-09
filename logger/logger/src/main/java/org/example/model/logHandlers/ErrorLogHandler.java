package org.example.model.logHandlers;

import org.example.model.Level;
import org.example.model.LogPublisher;

public class ErrorLogHandler extends AbstractLogHandler {
    public ErrorLogHandler(AbstractLogHandler logHandler) {
        super(Level.ERROR, logHandler);
    }

    @Override
    public void log(String log, LogPublisher logPublisher) {
        logPublisher.log(level, "[ERROR]" + log);
    }
}
