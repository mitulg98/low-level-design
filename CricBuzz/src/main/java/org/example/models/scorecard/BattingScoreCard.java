package org.example.models.scorecard;

import org.example.models.player.Player;

public class BattingScoreCard {
    private final Player player;
    private int runsScored = 0;
    private int ballsPlayed = 0;
    private boolean isOut = false;
    private double strikeRate = 0.0;

    public BattingScoreCard(Player player) {
        this.player = player;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public boolean isOut() {
        return isOut;
    }

    public double getStrikeRate() {
        return strikeRate;
    }
}
