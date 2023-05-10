package org.example;

import jdk.jfr.Event;
import org.example.listener.EmailListener;
import org.example.listener.Listener;
import org.example.listener.LoggingListener;

public class Main {
    public static void main(String[] args) {
        Listener fileOpenEmailListener = new EmailListener("xyz@123.com", "Following file is opened : ");
        Listener fileSaveLogListener = new LoggingListener("xyz.docx", "This file has been modified : ");
        Listener fileSaveEmailListener = new EmailListener("abc@742.in", "File has been screwed : ");
        Listener fileOpenLogListener = new LoggingListener("text.txt", "File has been opened : ");

        EventManager eventManager = new EventManager();
        eventManager.subscribe(fileOpenEmailListener, EventType.FILE_OPEN);
        eventManager.subscribe(fileSaveLogListener, EventType.FILE_SAVE);
        eventManager.subscribe(fileSaveEmailListener, EventType.FILE_SAVE);
        eventManager.subscribe(fileOpenLogListener, EventType.FILE_OPEN);

        Editor editor = new Editor(eventManager);
        editor.openFile("observer.java");
        editor.saveFile("decorator.cpp");
        editor.openFile("builder.txt");
    }
}