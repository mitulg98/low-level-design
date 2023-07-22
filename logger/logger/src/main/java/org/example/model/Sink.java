package org.example.model;

import org.example.interfaces.Logger;
import java.text.SimpleDateFormat;

public class Sink {
    private final Logger logger;
    private final SimpleDateFormat simpleDateFormat;
    private final Level level;

    public Sink(Logger logger, SimpleDateFormat simpleDateFormat, Level level) {
        this.logger = logger;
        this.simpleDateFormat = simpleDateFormat;
        this.level = level;
    }

    public void persistLog(String log) {
        logger.log(log);
    }

    public Logger getLogger() {
        return logger;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public Level getLevel() {
        return level;
    }
}
