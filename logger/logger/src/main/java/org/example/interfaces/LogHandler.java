package org.example.interfaces;

import org.example.model.LogPublisher;
import org.example.model.Message;

public interface LogHandler {
    void handleLog(Message message, LogPublisher logPublisher);
}
