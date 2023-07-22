package org.example.model;

public class Message {
    private final String content;
    private final Level level;
    private final String namespace;

    public Message(String content, Level level, String namespace) {
        this.content = content;
        this.level = level;
        this.namespace = namespace;
    }

    public String getContent() {
        return content;
    }

    public Level getLevel() {
        return level;
    }

    public String getNamespace() {
        return namespace;
    }
}
