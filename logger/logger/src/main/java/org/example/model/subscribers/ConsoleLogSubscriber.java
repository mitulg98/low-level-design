package org.example.model.subscribers;

import java.text.SimpleDateFormat;

public class ConsoleLogSubscriber extends AbstractLogSubscriber {
    public ConsoleLogSubscriber(SimpleDateFormat dateFormat) {
        super(dateFormat);
    }

    @Override
    public void log(String message) {
        lock.lock();

        try {
            System.out.println(appendDate(message));
        } finally {
            lock.unlock();
        }
    }
}
