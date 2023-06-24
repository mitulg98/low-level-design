package org.example.models;

import java.util.Date;

public class Task implements Cloneable {
    private final String taskId;
    private Date deadLine;
    private final Date startDate;
    private String tag;
    private String detail;
    private TaskStatus status;
    private final String userId;

    public Task(String taskId, Date deadLine, Date startDate, String tag, String detail, TaskStatus status, String userId) {
        this.taskId = taskId;
        this.deadLine = deadLine;
        this.startDate = startDate;
        this.tag = tag;
        this.detail = detail;
        this.status = status;
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getTag() {
        return tag;
    }

    public String getDetail() {
        return detail;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", deadLine=" + deadLine +
                ", tag='" + tag + '\'' +
                ", detail='" + detail + '\'' +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return new Task(taskId, deadLine, startDate, tag, detail, status, userId);
    }
}
