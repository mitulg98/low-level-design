package org.example.tasks;

import org.example.model.Message;
import org.example.model.Sink;

import java.util.Date;

public class LogTask implements Runnable {
    private final Message message;
    private final Sink sink;

    public LogTask(Message message, Sink sink) {
        this.message = message;
        this.sink = sink;
    }

    @Override
    public void run() {
        String stringBuilder = "[" + sink.getSimpleDateFormat()
                .format(new Date()) + "]" +
                message.getContent() +
                System.lineSeparator();
        sink.persistLog(stringBuilder);
    }
}
