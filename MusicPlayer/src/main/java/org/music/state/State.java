package org.music.state;

import org.music.Event;
import org.music.Player;

public abstract class State {
    Player player;

    State(Player player) {
        this.player = player;
    }

    public abstract void clickNext(Event event);
    public abstract void clickPrevious(Event event);
    public abstract void clickLock();
    public abstract void clickPlay();
}
