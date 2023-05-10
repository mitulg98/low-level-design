package org.example.listener;

public record LoggingListener(String logFileName, String message) implements Listener {
    @Override
    public void update(String data) {
        System.out.println("Logged to " + logFileName + " : " + message + " " + data);
    }
}
