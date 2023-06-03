package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.interfaces.Subscriber;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@RequiredArgsConstructor
public class TopicSubscriber {
    private final Subscriber subscriber;
    private AtomicInteger offSet = new AtomicInteger(0);
}
