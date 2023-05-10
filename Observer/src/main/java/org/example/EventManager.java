package org.example;

import org.example.listener.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<EventType, List<Listener>> listenerEventTypeMap = new HashMap<>();

    public void subscribe(Listener listener, EventType eventType) {
        listenerEventTypeMap.putIfAbsent(eventType, new ArrayList<>());
        listenerEventTypeMap.get(eventType).add(listener);
    }

    public void unsubscribe(Listener listener, EventType eventType) {
        listenerEventTypeMap.get(eventType).remove(listener);
    }

    public void notify(EventType eventType, String data) {
        listenerEventTypeMap.get(eventType)
                .forEach(listener -> listener.update(data));
    }
}
