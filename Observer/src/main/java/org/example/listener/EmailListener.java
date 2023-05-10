package org.example.listener;

public record EmailListener(String emailId, String message) implements Listener {
    @Override
    public void update(String data) {
        System.out.println("Sent to " + emailId + " : " + message + " " + data);
    }
}
