package org.example;

import org.example.models.Task;
import org.example.models.TaskStatus;

import java.util.*;

public class TaskHandler {
    private final Map<String, Task> tasksByTaskId;
    private final Map<String, List<Task>> tasksByTag;
    private final TreeMap<Date, List<Task>> tasksByDeadline;
    private final Map<TaskStatus, List<Task>> tasksByStatus;

    public TaskHandler() {
        tasksByTaskId = new HashMap<>();
        tasksByDeadline = new TreeMap<>();
        tasksByTag = new HashMap<>();
        tasksByStatus = new HashMap<>();
    }

    public void addTask(Task task) {
        tasksByTaskId.put(task.getTaskId(), task);
        tasksByTag.putIfAbsent(task.getTag(), new ArrayList<>());
        tasksByTag.get(task.getTag()).add(task);
        tasksByDeadline.putIfAbsent(task.getDeadLine(), new ArrayList<>());
        tasksByDeadline.get(task.getDeadLine()).add(task);
        tasksByStatus.putIfAbsent(task.getStatus(), new ArrayList<>());
        tasksByStatus.get(task.getStatus()).add(task);
    }

    public Task getTask(String taskId) {
        return tasksByTaskId.get(taskId);
    }

    public boolean isTaskCompleted(Task task) {
        return task.getStatus().equals(TaskStatus.COMPLETED);
    }

    public boolean isTaskSpilled(Task task) {
        return task.getStatus().equals(TaskStatus.PENDING) &&
                task.getDeadLine().before(getCurrentDate());
    }

    public void modifyTask(Task task) {
        if(task.getStatus().equals(TaskStatus.COMPLETED)) {
            removeTask(task.getTaskId());
            return;
        }

        Task oldTask = getTask(task.getTaskId());

        if(!oldTask.getTag().equals(task.getTag())) {
            tasksByTag.get(oldTask.getTag()).remove(oldTask);
            tasksByTag.putIfAbsent(task.getTag(), new ArrayList<>());
            tasksByTag.get(task.getTag()).add(task);
        }

        if(!oldTask.getDeadLine().equals(task.getDeadLine())) {
            tasksByDeadline.get(oldTask.getDeadLine()).remove(oldTask);
            tasksByDeadline.putIfAbsent(task.getDeadLine(), new ArrayList<>());
            tasksByDeadline.get(task.getDeadLine()).add(task);
        }
    }

    public void removeTask(String taskId) {
        Task task = getTask(taskId);
        tasksByTaskId.remove(taskId);
        tasksByStatus.get(task.getStatus()).remove(task);
        tasksByDeadline.get(task.getDeadLine()).remove(task);
        tasksByTag.get(task.getTag()).remove(task);
    }

    private Date getCurrentDate() {
        return new Date();
    }

    public void spillOverTask(Task task) {
        task.setStatus(TaskStatus.SPILLED_OVER);
        tasksByStatus.get(TaskStatus.PENDING).remove(task);
        tasksByStatus.get(TaskStatus.SPILLED_OVER).add(task);
    }

    public List<Task> getTasksByStatus(String status) {
        return tasksByStatus.get(TaskStatus.valueOf(status)).stream()
                .filter(task -> task.getStartDate().after(new Date()))
                .toList();
    }

    public List<Task> getTasksByDeadline(Date deadline) {
        return tasksByDeadline.get(deadline).stream()
                .filter(task -> task.getStartDate().after(new Date()))
                .toList();
    }

    public List<Task> getTasksWithDeadlineLessThan(Date deadline) {
        Date floorDate = tasksByDeadline.floorKey(deadline);
        List<Task> tasks = new ArrayList<>();
        for(Date date: tasksByDeadline.keySet()) {
            if(date.after(floorDate)) {
                break;
            }
            tasks.addAll(tasksByDeadline.get(date));
        }
        return tasks.stream()
                .filter(task -> task.getStartDate().after(new Date()))
                .toList();
    }

    public List<Task> getTasksWithDeadlineMoreThan(Date deadline) {
        Date ceilingDate = tasksByDeadline.ceilingKey(deadline);
        List<Task> tasks = new ArrayList<>();
        for(Date date: tasksByDeadline.descendingKeySet()) {
            if(date.before(ceilingDate)) {
                break;
            }
            tasks.addAll(tasksByDeadline.get(date));
        }
        return tasks.stream()
                .filter(task -> task.getStartDate().after(new Date()))
                .toList();
    }

    public List<Task> getTasksByTag(String tag) {
        return tasksByTag.get(tag).stream()
                .filter(task -> task.getStartDate().after(new Date()))
                .toList();
    }
}
