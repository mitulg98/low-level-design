package org.example.model.loggers;

import org.example.interfaces.Logger;

import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsoleLogger implements Logger {
    private PrintStream printStream;
    private Lock lock = new ReentrantLock();

    public ConsoleLogger(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void log(String log) {
        lock.lock();

        try {
            printStream.print(log);
        } finally {
            lock.unlock();
        }
    }
}
