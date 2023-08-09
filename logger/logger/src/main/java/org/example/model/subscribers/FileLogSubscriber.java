package org.example.model.subscribers;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileLogSubscriber extends AbstractLogSubscriber {
    private final String fileName;

    public FileLogSubscriber(String fileName, SimpleDateFormat dateFormat) {
        super(dateFormat);
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        lock.lock();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(appendDate(message));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
