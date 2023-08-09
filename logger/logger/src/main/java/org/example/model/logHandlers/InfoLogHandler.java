package org.example.model.logHandlers;

import org.example.model.Level;
import org.example.model.LogPublisher;

public class InfoLogHandler extends AbstractLogHandler {
    public InfoLogHandler(AbstractLogHandler logHandler) {
        super(Level.INFO, logHandler);
    }

    @Override
    public void log(String log, LogPublisher logPublisher) {
        logPublisher.log(level, "[INFO]" + log);
    }
}
