package org.example;

import lombok.SneakyThrows;
import org.example.interfaces.Queue;
import org.example.model.Message;
import org.example.model.Topic;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        final Queue queue = new Queue();
        final Topic topic1 = queue.createTopic("t1");
        final Topic topic2 = queue.createTopic("t2");
        final SleepingSubscriber sub1 = new SleepingSubscriber(10000, "sub1");
        final SleepingSubscriber sub2 = new SleepingSubscriber(10000, "sub2");
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub2, topic1);

        final SleepingSubscriber sub3 = new SleepingSubscriber(5000, "sub3");
        queue.subscribe(sub3, topic2);

        queue.publish(topic1, new Message("m1"));
        queue.publish(topic1, new Message("m2"));
//
//        queue.publish(topic2, new Message("m3"));

//        Thread.sleep(15000);
//        queue.publish(topic2, new Message("m4"));
//        queue.publish(topic1, new Message("m5"));
//
//        queue.resetOffSet(topic1, sub1, 0);
    }
}