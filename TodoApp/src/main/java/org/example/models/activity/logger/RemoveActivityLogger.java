package org.example.models.activity.logger;

import org.example.interfaces.ActivityLogger;
import org.example.models.Task;

public class RemoveActivityLogger implements ActivityLogger {
    private final Task task;

    public RemoveActivityLogger(Task task) {
        this.task = task;
    }

    @Override
    public void logActivity() {
        System.out.println("Task : " + task.getTaskId() + " is removed.");
        System.out.println(task);
    }
}
