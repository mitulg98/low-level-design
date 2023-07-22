package org.example.service;

import org.example.models.delivery.BallType;
import org.example.models.delivery.RunType;
import org.example.models.player.Player;
import org.example.models.scorecard.BattingScoreCard;
import org.example.models.scorecard.BowlingScoreCard;

public class PlayerHandler {
    public BallType bowl() {
        return BallType.values()[getRandomNumber(3)];
    }

    public RunType bat() {
        int ordinal = getRandomNumber(7);
        return RunType.values()[ordinal];
    }

    public void updateBatterScoreCard(Player player, int runs, boolean isOut) {
        BattingScoreCard battingScoreCard = player.getBattingScoreCard();

        int ballsPlayed = battingScoreCard.getBallsPlayed() + 1;
        int runsScored = battingScoreCard.getRunsScored() + runs;

        battingScoreCard.setBallsPlayed(ballsPlayed);
        battingScoreCard.setRunsScored(runsScored);
        battingScoreCard.setStrikeRate((runsScored * 100.0) / ballsPlayed);
        battingScoreCard.setOut(isOut);
    }

    public void updateBowlingScoreCard(Player player, BallType ballType, int runsHit, boolean isWicket,
                                       boolean isFairDelivery) {

        BowlingScoreCard bowlingScoreCard = player.getBowlingScoreCard();

        int totalRunsHit = bowlingScoreCard.getRunsHit() + runsHit + (isFairDelivery ? 0 : 1);
        int noBalls = bowlingScoreCard.getNoBalls() + (ballType.equals(BallType.NO_BALL) ? 1 : 0);
        int wideBalls = bowlingScoreCard.getWideBalls() + (ballType.equals(BallType.WIDE_BALL) ? 1 : 0);
        int numberOfWickets = bowlingScoreCard.getNumberOfWickets() + (isWicket ? 1 : 0);
        double over = (isFairDelivery ? updateOver(bowlingScoreCard.getOvers()) : bowlingScoreCard.getOvers());

        bowlingScoreCard.setEconomy(totalRunsHit / over);
        bowlingScoreCard.setNoBalls(noBalls);
        bowlingScoreCard.setOvers(over);
        bowlingScoreCard.setWideBalls(wideBalls);
        bowlingScoreCard.setNumberOfWickets(numberOfWickets);
    }

    public int getRandomNumber(int limit) {
        return (int) (Math.random() * limit);
    }

    private double updateOver(double overs) {
        overs += 0.1;

        if(overs - Math.floor(overs) - 0.6 >= 0) {
            overs = Math.ceil(overs);
        }

        return overs;
    }
}
