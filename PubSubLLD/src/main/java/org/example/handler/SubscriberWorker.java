package org.example.handler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.List;

@RequiredArgsConstructor
public class SubscriberWorker implements Runnable {
    private final TopicSubscriber topicSubscriber;
    private final Topic topic;

    @SneakyThrows
    @Override
    public void run(){
        synchronized(topicSubscriber) {
            do {
                List<Message> messages = topic.getMessages();
                int offSet = topicSubscriber.getOffSet()
                        .intValue();

                while (offSet >= messages.size()) {
                    topicSubscriber.wait();
                }

                topicSubscriber.getSubscriber()
                        .update(messages.get(offSet));

                topicSubscriber.getOffSet()
                        .compareAndSet(offSet, offSet + 1);
            } while (true);
        }
    }

    public synchronized void awake() {
        synchronized(topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
