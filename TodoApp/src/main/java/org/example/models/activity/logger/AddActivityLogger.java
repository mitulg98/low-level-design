package org.example.models.activity.logger;

import org.example.interfaces.ActivityLogger;
import org.example.models.Task;

public class AddActivityLogger implements ActivityLogger {
    private final Task task;

    public AddActivityLogger(Task task) {
        this.task = task;
    }

    @Override
    public void logActivity() {
        System.out.println("New task added : " + task);
    }
}
