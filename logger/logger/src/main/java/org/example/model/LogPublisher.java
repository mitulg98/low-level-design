package org.example.model;

import org.example.interfaces.LogSubscriber;

import java.util.*;

public class LogPublisher {
    private final Map<Level, List<LogSubscriber>> subscribers = new HashMap<>();

    public void addSubscriber(LogSubscriber logSubscriber, Level level) {
        subscribers.putIfAbsent(level, new ArrayList<>());
        subscribers.get(level).add(logSubscriber);
    }

    public void log(Level level, String message) {
        List<LogSubscriber> subscribersList = subscribers.get(level);

        if(subscribersList != null) {
            subscribers.get(level).forEach(subscriber -> {
                (new Thread(() -> {
                    subscriber.log(message);
                })).start();
            });
        }
    }
}
