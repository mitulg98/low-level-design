package org.example.models.match;

import org.example.models.player.Team;
import org.example.models.delivery.Over;
import org.example.models.player.Player;
import org.example.models.scorecard.BattingScoreCard;
import org.example.models.scorecard.BowlingScoreCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inning {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private final int inningNumber;
    private final Map<Player, BattingScoreCard> battingScoreCards;
    private final Map<Player, BowlingScoreCard> bowlingScoreCards;
    private Player batterOnStrike;
    private Player currentBowler;
    private Player batterOnNonStrike;
    private final List<Over> overs;
    private int runsScored = 0;
    private int wicketsLost = 0;
    private int extras = 0;

    public Inning(Team battingTeam, Team bowlingTeam, int inningNumber) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.inningNumber = inningNumber;
        this.battingScoreCards = new HashMap<>();
        this.bowlingScoreCards = new HashMap<>();
        this.overs = new ArrayList<>();
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public Map<Player, BattingScoreCard> getBattingScoreCards() {
        return battingScoreCards;
    }

    public Map<Player, BowlingScoreCard> getBowlingScoreCards() {
        return bowlingScoreCards;
    }

    public Player getBatterOnStrike() {
        return batterOnStrike;
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public Player getBatterOnNonStrike() {
        return batterOnNonStrike;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setBatterOnStrike(Player batterOnStrike) {
        this.batterOnStrike = batterOnStrike;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

    public void setBatterOnNonStrike(Player batterOnNonStrike) {
        this.batterOnNonStrike = batterOnNonStrike;
    }

    public void addBattingScoreCard(BattingScoreCard battingScoreCard) {
        battingScoreCards.put(battingScoreCard.getPlayer(), battingScoreCard);
    }

    public void addBowlingScoreCard(BowlingScoreCard bowlingScoreCard) {
        bowlingScoreCards.put(bowlingScoreCard.getPlayer(), bowlingScoreCard);
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    public int getExtras() {
        return extras;
    }

    public void updateRuns(int runs) {
        runsScored += runs;
    }

    public void updateWickets() {
        wicketsLost++;
    }

    public void updateExtras(int extras) {
        this.extras += extras;
    }
}
