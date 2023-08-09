package org.example.model.logHandlers;

import org.example.model.Level;
import org.example.model.LogPublisher;

public class FatalLogHandler extends AbstractLogHandler {
    public FatalLogHandler(AbstractLogHandler logHandler) {
        super(Level.FATAL, logHandler);
    }

    @Override
    public void log(String log, LogPublisher logPublisher) {
        logPublisher.log(level, "[FATAL]" + log);
    }
}
