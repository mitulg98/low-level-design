package org.example.interfaces;

import org.example.SleepingSubscriber;
import org.example.handler.TopicManager;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.*;

public class Queue {
    private final Map<String, TopicManager> topicManagers = new HashMap<>();

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(UUID.randomUUID().toString(), topicName);
        TopicManager topicManager = new TopicManager(topic);
        topicManagers.put(topic.getTopicId(), topicManager);
        return topic;
    }

    public void subscribe(Subscriber subscriber, Topic topic) {
        TopicSubscriber topicSubscriber = new TopicSubscriber(subscriber);
        topic.getSubscribers().add(topicSubscriber);
    }

    public void publish(Topic topic, Message message) {
        topic.getMessages().add(message);
        Thread thread = new Thread(() -> {
            topicManagers.get(topic.getTopicId())
                    .publish();
        });
        thread.start();
    }

    public void resetOffSet(Topic topic, Subscriber subscriber, int offSet) {
        Thread thread = new Thread(() -> {
            topicManagers.get(topic.getTopicId())
                    .resetOffSet(subscriber, offSet);
        });
        thread.start();
    }
}
