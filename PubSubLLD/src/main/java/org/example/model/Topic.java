package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Topic {
    private final String topicId;
    private final String topicName;
    private List<TopicSubscriber> subscribers = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
}
