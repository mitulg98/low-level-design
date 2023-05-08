package org.music;

public class Event {
    private final boolean isDoubleClick;

    public Event(boolean isDoubleClick) {
        this.isDoubleClick = isDoubleClick;
    }

    public boolean isDoubleClick() {
        return isDoubleClick;
    }
}
