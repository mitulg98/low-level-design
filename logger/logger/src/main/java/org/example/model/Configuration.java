package org.example.model;

import java.text.SimpleDateFormat;

public class Configuration {
    private final SimpleDateFormat timeFormat;
    private final Level level;
    private final SinkType sinkType;
    private final String sinkDestination;

    public Configuration(SimpleDateFormat timeFormat, Level level, SinkType sinkType, String sinkDestination) {
        this.timeFormat = timeFormat;
        this.level = level;
        this.sinkType = sinkType;
        this.sinkDestination = sinkDestination;
    }

    public SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }

    public Level getLevel() {
        return level;
    }

    public SinkType getSinkType() {
        return sinkType;
    }

    public String getSinkDestination() {
        return sinkDestination;
    }
}
