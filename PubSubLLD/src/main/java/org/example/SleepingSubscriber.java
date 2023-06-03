package org.example;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.interfaces.Subscriber;
import org.example.model.Message;

@AllArgsConstructor
public class SleepingSubscriber implements Subscriber {
    private int sleepTime;
    private String id;

    @Override
    @SneakyThrows
    public void update(Message message) {
        System.out.println(id + " starting to consume message : " + message.getMessage());
        Thread.sleep(sleepTime);
        System.out.println(id + " done consuming message : " + message.getMessage());
    }
}
