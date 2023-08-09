package org.example.model.logHandlers;

import org.example.model.Level;
import org.example.model.LogPublisher;

public class WarnLogHandler extends AbstractLogHandler {
    public WarnLogHandler(AbstractLogHandler logHandler) {
        super(Level.WARN, logHandler);
    }

    @Override
    public void log(String log, LogPublisher logPublisher) {
        logPublisher.log(level, "[WARN]" + log);
    }
}
