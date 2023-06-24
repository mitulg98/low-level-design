package org.example;

import org.example.models.*;
import org.example.models.activity.Activity;
import org.example.models.activity.ActivityType;
import org.example.models.activity.logger.AddActivityLogger;
import org.example.models.activity.logger.ModifyActivityLogger;
import org.example.models.activity.logger.RemoveActivityLogger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TodoApplication {
    private final TaskHandler taskHandler;
    private final ActivityAuditor activityAuditor;
    private final StatisticsHandler statisticsHandler;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public TodoApplication() {
        this.taskHandler = new TaskHandler();
        this.activityAuditor = new ActivityAuditor();
        this.statisticsHandler = new StatisticsHandler();
    }

    public List<Task> listTasks(List<FilterExpression> filterExpressions, OrderExpression orderExpression) throws ParseException {
        Set<Task> tasks = new HashSet<>();

        for(FilterExpression filterExpression: filterExpressions) {
            switch (filterExpression.getPropertyName()) {
                case "taskId" -> tasks.add(taskHandler.getTask(filterExpression.getValue()));
                case "status" -> {
                    List<Task> tasksWithStatus = taskHandler.getTasksByStatus(filterExpression.getValue());
                    if (tasksWithStatus.stream()
                            .anyMatch(taskHandler::isTaskSpilled)) {
                        tasksWithStatus.stream()
                                .filter(taskHandler::isTaskSpilled)
                                .forEach(taskHandler::spillOverTask);
                        tasksWithStatus = taskHandler.getTasksByStatus(filterExpression.getValue());
                    }
                    tasks.addAll(tasksWithStatus);
                }
                case "deadline" -> {
                    Operator operator = filterExpression.getOperator();
                    Date date = simpleDateFormat.parse(filterExpression.getValue());
                    if (operator.equals(Operator.EQ)) {
                        tasks.addAll(taskHandler.getTasksByDeadline(date));
                    } else if(operator.equals(Operator.LT)) {
                        tasks.addAll(taskHandler.getTasksWithDeadlineLessThan(date));
                    } else {
                        tasks.addAll(taskHandler.getTasksWithDeadlineMoreThan(date));
                    }
                }
                case "tag" -> tasks.addAll(taskHandler.getTasksByTag(filterExpression.getValue()));
            }
        }

        tasks.stream()
                .filter(taskHandler::isTaskSpilled)
                .forEach(task -> {
                    taskHandler.spillOverTask(task);
                    statisticsHandler.recordStatistics(StatisticsType.SPILL_OVER);
                });

        return new ArrayList<>(tasks);
    }

    public void addTask(Task task) throws CloneNotSupportedException {
        activityAuditor.addActivity(new Activity(ActivityType.ADD,
                new AddActivityLogger(task)));
        task = task.clone();
        taskHandler.addTask(task);
    }

    public void modifyTask(Task task) {
        if(taskHandler.isTaskCompleted(task)) {
            statisticsHandler.recordStatistics(StatisticsType.COMPLETION);
        }

        activityAuditor.addActivity(new Activity(ActivityType.MODIFY,
                new ModifyActivityLogger(taskHandler.getTask(task.getTaskId()), task)));
        taskHandler.modifyTask(task);

        if(taskHandler.isTaskSpilled(task)) {
            statisticsHandler.recordStatistics(StatisticsType.SPILL_OVER);
            taskHandler.spillOverTask(task);
        }
    }

    public Task getTask(String taskId) {
        return taskHandler.getTask(taskId);
    }

    public void removeTask(String taskId) {
        activityAuditor.addActivity(new Activity(ActivityType.REMOVE,
                new RemoveActivityLogger(taskHandler.getTask(taskId))));
        taskHandler.removeTask(taskId);
    }

    public String getStatistics(TimeDuration timeDuration) {
        return statisticsHandler.getStatistics(timeDuration.getStartDate(),
                timeDuration.getEndDate());
    }

    public List<Activity> getActivity(TimeDuration timeDuration) {
        return activityAuditor.getActivities(timeDuration.getStartDate(),
                timeDuration.getEndDate());
    }
}
