package org.example.service;

import org.example.models.player.Player;
import org.example.models.player.Team;

public class TeamHandler {
    public Player getNextBatter(Team team) {
        return team.getBattingPlayerGenerator().getNextPlayer();
    }

    public Player getNextBowler(Team team) {
        return team.getBowlingPlayerGenerator().getNextPlayer();
    }
}
