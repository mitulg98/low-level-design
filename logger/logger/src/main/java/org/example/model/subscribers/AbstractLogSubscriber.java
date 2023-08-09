package org.example.model.subscribers;

import org.example.interfaces.LogSubscriber;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractLogSubscriber implements LogSubscriber {
    private SimpleDateFormat dateFormat;
    protected Lock lock = new ReentrantLock();

    public AbstractLogSubscriber(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    protected String appendDate(String message) {
        return "[" + dateFormat.format(new Date()) + "]" + message;
    }
}
