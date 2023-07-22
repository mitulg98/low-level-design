package org.example.service;

import org.example.Queue;
import org.example.models.delivery.BallType;
import org.example.models.delivery.Delivery;
import org.example.models.delivery.Over;
import org.example.models.delivery.RunType;
import org.example.models.match.Inning;
import org.example.models.match.Match;
import org.example.models.player.Player;

import java.util.Set;

public class InningHandler {
    private final ReportHandler reportHandler;
    private final TeamHandler teamHandler;
    private final PlayerHandler playerHandler;
    private final Queue queue;
    private final Match match;

    public InningHandler(Match match) {
        this.reportHandler = new ReportHandler();
        this.queue = new Queue();
        this.playerHandler = new PlayerHandler();
        this.teamHandler = new TeamHandler();
        this.match = match;
    }

    public void startInning(Inning inning) {
        while(inning.getWicketsLost() < 10 && inning.getOvers().size() < match.getMatchType().getTotalOvers()) {
            boolean isFairDelivery = executeDelivery(inning);

            while(!isFairDelivery) {
                isFairDelivery = executeDelivery(inning);
            }

            Player bowler = inning.getCurrentBowler();
            double oversByBowler = bowler.getBowlingScoreCard().getOvers();

            if(oversByBowler == Math.floor(oversByBowler)) {
                Player newBowler = teamHandler.getNextBowler(inning.getBowlingTeam());
                inning.setCurrentBowler(newBowler);
                inning.getBowlingScoreCards().putIfAbsent(newBowler, newBowler.getBowlingScoreCard());
                inning.getOvers().add(new Over());
            }
        }
    }

    private boolean executeDelivery(Inning inning) {
        Player bowler = inning.getCurrentBowler();
        Player batter = inning.getBatterOnStrike();

        BallType ballType = playerHandler.bowl();
        RunType runType = playerHandler.bat();
        boolean isNoBall = ballType.equals(BallType.NO_BALL);
        boolean isOut = runType.equals(RunType.WICKET) && !isNoBall;
        boolean isFairDelivery = isExtra(ballType);

        playerHandler.updateBatterScoreCard(batter, runType.getRun(), isOut);
        playerHandler.updateBowlingScoreCard(bowler, ballType, runType.getRun(), isOut, isFairDelivery);

        if(!isOut && runType.equals(RunType.WICKET)) {
            runType = RunType.ZERO;
        }
        
        Delivery delivery = new Delivery(ballType, runType);
        Over over = inning.getOvers().get(inning.getOvers().size() - 1);
        over.addDelivery(delivery);

        if(isOut) {
            inning.updateWickets();
            Player newBatter = teamHandler.getNextBatter(inning.getBattingTeam());
            inning.setBatterOnStrike(newBatter);
            inning.getBattingScoreCards().put(newBatter, newBatter.getBattingScoreCard());
        }

        int extraRuns = isFairDelivery ? 0 : 1;

        inning.updateExtras(extraRuns);
        inning.updateRuns(runType.getRun() + extraRuns);

        reportHandler.createReport(inning);

        handleOddRun(inning, batter, runType);

        return isFairDelivery;
    }

    private void handleOddRun(Inning inning, Player batter, RunType runType) {
        if(isOddRun(runType)) {
            inning.setBatterOnStrike(inning.getBatterOnNonStrike());
            inning.setBatterOnNonStrike(batter);
        }
    }

    private boolean isOddRun(RunType runType) {
        Set<RunType> oddRuns = Set.of(RunType.ONE, RunType.THREE);
        return oddRuns.contains(runType);
    }

    private boolean isExtra(BallType ballType) {
        return ballType.equals(BallType.NO_BALL) ||
                ballType.equals(BallType.WIDE_BALL);
    }
}
