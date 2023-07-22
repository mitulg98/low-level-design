package org.example.model.loggers;

import org.example.interfaces.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseLogger implements Logger {
    private final String databaseUrl;
    private final Lock lock = new ReentrantLock();

    public DatabaseLogger(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public void log(String log) {

    }
}
