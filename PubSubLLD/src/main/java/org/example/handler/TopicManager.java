package org.example.handler;

import lombok.RequiredArgsConstructor;
import org.example.interfaces.Subscriber;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class TopicManager {
    private final Topic topic;
    private final Map<TopicSubscriber, SubscriberWorker> subscriberWorkers = new HashMap<>();

    public void publish() {
        for(TopicSubscriber subscriber: topic.getSubscribers()) {
            startSubscriberWorker(subscriber);
        }
    }

    private void startSubscriberWorker(TopicSubscriber subscriber) {
        if(!subscriberWorkers.containsKey(subscriber)) {
            SubscriberWorker worker = new SubscriberWorker(subscriber, topic);
            subscriberWorkers.put(subscriber, worker);
            Thread thread = new Thread(worker);
            thread.start();
        } else {
            SubscriberWorker worker = subscriberWorkers.get(subscriber);
            worker.awake();
        }
    }

    public void resetOffSet(Subscriber subscriber, int newOffSet) {
        TopicSubscriber topicSubscriber = topic.getSubscribers()
                .stream()
                .filter(topicSubscriber1 -> topicSubscriber1.getSubscriber().equals(subscriber))
                .toList()
                .get(0);

        topicSubscriber.getOffSet().set(newOffSet);
        startSubscriberWorker(topicSubscriber);
    }
}
