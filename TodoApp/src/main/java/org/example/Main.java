package org.example;

import org.example.models.*;
import org.example.models.activity.Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        TodoApplication todoApplication = new TodoApplication();

        Task task1 = new Task(UUID.randomUUID().toString(),
                df.parse("12-07-2023"),
                df.parse("12-05-2023"),
                "#java",
                "First task",
                TaskStatus.PENDING,
                UUID.randomUUID().toString());

        Task task2 = new Task(UUID.randomUUID().toString(),
                df.parse("12-08-2023"),
                df.parse("12-07-2023"),
                "#dev",
                "Second task",
                TaskStatus.PENDING,
                UUID.randomUUID().toString());

        Task task3 = new Task(UUID.randomUUID().toString(),
                df.parse("01-04-2023"),
                df.parse("11-10-2023"),
                "#go",
                "Third task",
                TaskStatus.PENDING,
                UUID.randomUUID().toString());

        Task task4 = new Task(UUID.randomUUID().toString(),
                df.parse("01-04-2023"),
                df.parse("11-06-2023"),
                "#go",
                "Fourth task",
                TaskStatus.PENDING,
                UUID.randomUUID().toString());

        todoApplication.addTask(task1);
        todoApplication.addTask(task2);
        todoApplication.addTask(task3);
        todoApplication.addTask(task4);

        task1.setStatus(TaskStatus.COMPLETED);
        todoApplication.modifyTask(task1);

        todoApplication.removeTask(task4.getTaskId());

        System.out.println(todoApplication.listTasks(List.of(new FilterExpression("tag", Operator.EQ, "#java")), null));

        todoApplication.getActivity(new TimeDuration(df.parse("11-05-2023"),
                df.parse("10-10-2023"))).forEach(Activity::logActivity);

        System.out.println(todoApplication.getStatistics(new TimeDuration(df.parse("11-05-2023"),
                df.parse("10-10-2023"))));

    }
}