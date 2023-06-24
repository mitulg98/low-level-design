package org.example.models.activity.logger;

import org.example.interfaces.ActivityLogger;
import org.example.models.Task;

public class ModifyActivityLogger implements ActivityLogger {
    private final Task oldTask;
    private final Task newTask;

    public ModifyActivityLogger(Task oldTask, Task newTask) {
        this.oldTask = oldTask;
        this.newTask = newTask;
    }

    @Override
    public void logActivity() {
        System.out.println("Task : " + oldTask.getTaskId() + " modified.");
        System.out.println("Here are the changes : ");

        if(!oldTask.getTag().equals(newTask.getTag())) {
            System.out.println("Tag changed from " + oldTask.getTag() + " to " + newTask.getTag());
        }

        if(!oldTask.getDeadLine().equals(newTask.getDeadLine())) {
            System.out.println("Deadline changed from " + oldTask.getDeadLine() + " to " + newTask.getDeadLine());
        }

        if(!oldTask.getDetail().equals(newTask.getDetail())) {
            System.out.println("Detail changed from " + oldTask.getDetail() + " to " + newTask.getDetail());
        }

        if(!oldTask.getStatus().equals(newTask.getStatus())) {
            System.out.println("Status changed from " + oldTask.getStatus() + " to " + newTask.getStatus());
        }
    }
}
