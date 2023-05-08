package org.music.state;

import org.music.Event;
import org.music.Player;

public class ReadyState extends State {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public void clickNext(Event event) {
        player.nextSong();
    }

    @Override
    public void clickPrevious(Event event) {
        player.previousSong();
    }

    @Override
    public void clickLock() {
        player.changeState(new LockedState(player));
    }

    @Override
    public void clickPlay() {
        player.startPlayback();
        player.changeState(new PlayingState(player));
    }
}
