package org.example.model.loggers;

import org.example.interfaces.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileLogger implements Logger {
    private final String fileName;
    private final Lock lock = new ReentrantLock();

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String log) {
        lock.lock();
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(log);
            fileWriter.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
