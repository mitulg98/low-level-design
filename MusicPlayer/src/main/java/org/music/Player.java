package org.music;

import org.music.state.ReadyState;
import org.music.state.State;

public class Player {
    private State state;
    private PlayList playList;
    private Song currentSong;
    private boolean isPlaying;

    public Player() {
        state = new ReadyState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void clickNext(Event event) {
        state.clickNext(event);
    }

    public void clickPrevious(Event event) {
        state.clickPrevious(event);
    }

    public void clickPlay() {
        state.clickPlay();
    }

    public void clickLock() {
        state.clickLock();
    }

    public void nextSong() {

    }

    public void previousSong() {

    }

    public void startPlayback() {

    }

    public void stopPlayback() {

    }

    public void fastForward(int time) {

    }

    public void rewind(int time) {

    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
