package org.music.state;

import org.music.Event;
import org.music.Player;

public class LockedState extends State {
    public LockedState(Player player) {
        super(player);
    }

    @Override
    public void clickNext(Event event) {
        // Locked, so do nothing.
    }

    @Override
    public void clickPrevious(Event event) {
        // Locked, so do nothing.
    }

    @Override
    public void clickLock() {
        if(player.isPlaying()) {
            player.changeState(new PlayingState(player));
        } else {
            player.changeState(new PlayingState(player));
        }
    }

    @Override
    public void clickPlay() {
        // Locked, so do nothing.
    }
}
