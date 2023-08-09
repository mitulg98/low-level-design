package org.example.model.logHandlers;

import org.example.model.Level;
import org.example.model.LogPublisher;

public class DebugLogHandler extends AbstractLogHandler {

    public DebugLogHandler(AbstractLogHandler logHandler) {
        super(Level.DEBUG, logHandler);
    }

    @Override
    public void log(String log, LogPublisher logPublisher) {
        logPublisher.log(level, "[DEBUG]" + log);
    }
}
