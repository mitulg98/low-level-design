package org.example.model.logHandlers;

import org.example.interfaces.LogHandler;
import org.example.model.Level;
import org.example.model.LogPublisher;
import org.example.model.Message;

public abstract class AbstractLogHandler implements LogHandler {
    protected final Level level;

    private final AbstractLogHandler nextLogHandler;

    public AbstractLogHandler(Level level, AbstractLogHandler logHandler) {
        this.level = level;
        this.nextLogHandler = logHandler;
    }

    @Override
    public void handleLog(Message message, LogPublisher logPublisher) {
        if(message.getLevel().getValue() >= level.getValue()) {
            this.log(appendNameSpace(message.getContent(), message.getNamespace()), logPublisher);
        }
        if(nextLogHandler != null) {
            nextLogHandler.handleLog(message, logPublisher);
        }
    }

    private String appendNameSpace(String content, String nameSpace) {
        return "[" + nameSpace + "]" + content;
    }

    public abstract void log(String log, LogPublisher logPublisher);
}
