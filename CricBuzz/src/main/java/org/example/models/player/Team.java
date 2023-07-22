package org.example.models.player;

import org.example.interfaces.PlayerGenerator;
import org.example.models.player.Player;

import java.util.List;

public class Team {
    private final String teamName;
    private final List<Player> playing11;
    private final List<Player> benchedPlayers;
    private final PlayerGenerator battingPlayerGenerator;
    private final PlayerGenerator bowlingPlayerGenerator;

    public Team(String teamName, List<Player> playing11, List<Player> benchedPlayers,
                PlayerGenerator battingPlayerGenerator, PlayerGenerator bowlingPlayerGenerator) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.benchedPlayers = benchedPlayers;
        this.battingPlayerGenerator = battingPlayerGenerator;
        this.bowlingPlayerGenerator = bowlingPlayerGenerator;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlaying11() {
        return playing11;
    }

    public List<Player> getBenchedPlayers() {
        return benchedPlayers;
    }

    public PlayerGenerator getBattingPlayerGenerator() {
        return battingPlayerGenerator;
    }

    public PlayerGenerator getBowlingPlayerGenerator() {
        return bowlingPlayerGenerator;
    }
}
