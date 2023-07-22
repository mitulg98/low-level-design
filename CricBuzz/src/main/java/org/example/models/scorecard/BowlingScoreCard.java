package org.example.models.scorecard;

import org.example.models.player.Player;

public class BowlingScoreCard {
    private final Player player;
    private int numberOfWickets = 0;
    private double overs = 0.0;
    private int wideBalls = 0;
    private int noBalls = 0;
    private int runsHit = 0;
    private double economy = 0;

    public BowlingScoreCard(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberOfWickets() {
        return numberOfWickets;
    }

    public double getOvers() {
        return overs;
    }

    public int getWideBalls() {
        return wideBalls;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public int getRunsHit() {
        return runsHit;
    }

    public double getEconomy() {
        return economy;
    }

    public void setNumberOfWickets(int numberOfWickets) {
        this.numberOfWickets = numberOfWickets;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public void setWideBalls(int wideBalls) {
        this.wideBalls = wideBalls;
    }

    public void setNoBalls(int noBalls) {
        this.noBalls = noBalls;
    }

    public void setRunsHit(int runsHit) {
        this.runsHit = runsHit;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }
}
