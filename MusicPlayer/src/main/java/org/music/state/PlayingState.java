package org.music.state;

import org.music.Event;
import org.music.Player;

public class PlayingState extends State {
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public void clickNext(Event event) {
        if(event.isDoubleClick()) {
            player.fastForward(15);
        } else {
            player.nextSong();
        }
    }

    @Override
    public void clickPrevious(Event event) {
        if(event.isDoubleClick()) {
            player.rewind(15);
        } else {
            player.previousSong();
        }
    }

    @Override
    public void clickLock() {
        player.changeState(new LockedState(player));
    }

    @Override
    public void clickPlay() {
        player.stopPlayback();
        player.changeState(new ReadyState(player));
    }
}
