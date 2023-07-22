package org.example.model;

import org.example.interfaces.Logger;
import org.example.model.loggers.ConsoleLogger;
import org.example.model.loggers.DatabaseLogger;
import org.example.model.loggers.FileLogger;
import org.example.tasks.LogTask;

import java.util.*;

public class LoggingSystem {
    private Map<Level, List<Sink>> sinks = new HashMap<>();
    private static final List<Level> LEVELS = Arrays.asList(Level.values());

    public LoggingSystem() {
        for(Level level: LEVELS) {
            sinks.put(level, new ArrayList<>());
        }
    }

    public void addConfiguration(Configuration configuration) {
        Logger logger = null;

        switch(configuration.getSinkType()) {
            case DATABASE -> {
                logger = new DatabaseLogger(configuration.getSinkDestination());
            }
            case CONSOLE -> {
                logger = new ConsoleLogger(System.out);
            }
            case FILE -> {
                logger = new FileLogger(configuration.getSinkDestination());
            }
        }

        Level level = configuration.getLevel();
        Sink sink = new Sink(logger, configuration.getTimeFormat(), level);

        for(int i = level.getValue(); i < LEVELS.size(); i++) {
            sinks.get(LEVELS.get(i)).add(sink);
        }
    }

    public void logMessage(Message message) {
        Level level = message.getLevel();

        for(Sink sink: sinks.get(level)) {
            (new Thread(new LogTask(message, sink))).start();
        }
    }
}
