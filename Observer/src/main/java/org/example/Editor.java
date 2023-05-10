package org.example;

public class Editor {
    private final EventManager eventManager;

    public Editor(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void openFile(String fileName) {
        eventManager.notify(EventType.FILE_OPEN, fileName);
    }

    public void saveFile(String fileName) {
        eventManager.notify(EventType.FILE_SAVE, fileName);
    }
}
