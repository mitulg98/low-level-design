package org.example.models.player;

import org.example.interfaces.PlayerGenerator;

import java.util.List;

public class BattingPlayerGenerator implements PlayerGenerator {
    private final Team team;

    public BattingPlayerGenerator(Team team) {
        this.team = team;
    }

    @Override
    public Player getNextPlayer() {
        return team.getPlaying11().stream()
                .filter(player -> !player.getBattingScoreCard().isOut())
                .findFirst()
                .orElse(null);
    }
}
