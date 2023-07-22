package org.example.models.player;

import org.example.interfaces.PlayerGenerator;
import org.example.models.player.Player;
import org.example.models.player.Team;

public class BowlingPlayerGenerator implements PlayerGenerator {
    private final Team team;

    public BowlingPlayerGenerator(Team team) {
        this.team = team;
    }

    @Override
    public Player getNextPlayer() {
        return team.getPlaying11().stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.BOWLER) ||
                        player.getPlayerType().equals(PlayerType.ALL_ROUNDER))
                .findFirst()
                .orElse(null);
    }
}
