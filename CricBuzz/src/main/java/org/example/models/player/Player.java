package org.example.models.player;

import org.example.models.scorecard.BattingScoreCard;
import org.example.models.scorecard.BowlingScoreCard;

public class Player {
    private final Person person;
    private final BattingScoreCard battingScoreCard;
    private final BowlingScoreCard bowlingScoreCard;
    private final PlayerType playerType;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        battingScoreCard = new BattingScoreCard(this);
        bowlingScoreCard = new BowlingScoreCard(this);
    }

    public Person getPerson() {
        return person;
    }

    public BattingScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }

    public BowlingScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
