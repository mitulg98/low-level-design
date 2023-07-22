package org.example.service;

import org.example.models.delivery.BallType;
import org.example.models.delivery.Delivery;
import org.example.models.delivery.Over;
import org.example.models.delivery.RunType;
import org.example.models.match.Inning;
import org.example.models.player.Player;
import org.example.models.player.Team;
import org.example.models.scorecard.BattingScoreCard;
import org.example.models.scorecard.BowlingScoreCard;

import java.util.Map;

public class ReportHandler {
    public void createReport(Inning inning) {
        Player currentBatter = inning.getBatterOnStrike();
        Player runner = inning.getBatterOnNonStrike();
        Player bowler = inning.getCurrentBowler();

        Map<Player, BattingScoreCard> battingScoreCardMap = inning.getBattingScoreCards();
        BowlingScoreCard bowlingScoreCard = inning.getBowlingScoreCards().get(bowler);

        Over over = inning.getOvers().get(inning.getOvers().size() - 1);

        Team battingTeam = inning.getBattingTeam();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("---------- Score Card ----------\n")
                .append(battingTeam.getTeamName())
                .append(" : ")
                .append(inning.getRunsScored());

        if(inning.getWicketsLost() < 10) {
            stringBuilder.append(" - ")
                    .append(inning.getWicketsLost());
        }

        stringBuilder.append("\n")
                .append("This Over : ");

        for(Delivery delivery: over.getDeliveries()) {
            RunType runType = delivery.getRunType();
            BallType ballType = delivery.getBallType();

            if(runType.equals(RunType.WICKET)) {
                stringBuilder.append("W ");
            } else {
                if(ballType.equals(BallType.NO_BALL)) {
                    stringBuilder.append("NB");
                } else if(ballType.equals(BallType.WIDE_BALL)) {
                    stringBuilder.append("WB");
                }

                if(ballType.equals(BallType.NORMAL_BALL)) {
                    if(runType.getRun() == 0) {
                        stringBuilder.append("* ");
                    } else {
                        stringBuilder.append(runType.getRun())
                                .append(" ");
                    }
                } else {
                    if(runType.getRun() > 0) {
                        stringBuilder.append(runType.getRun());
                    }
                    stringBuilder.append(" ");
                }
            }
        }

        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }
}
