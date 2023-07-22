package org.example.models.match;

import org.example.models.player.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
    private final Date date;
    private final String venue;
    private final MatchType matchType;
    private final List<Inning> innings;
    private final Team firstTeam;
    private final Team secondTeam;
    private Team tossWinner;

    public Match(Date date, String venue, MatchType matchType, Team firstTeam, Team secondTeam) {
        this.date = date;
        this.venue = venue;
        this.matchType = matchType;
        this.innings = new ArrayList<>();
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public Date getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public Team getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(Team tossWinner) {
        this.tossWinner = tossWinner;
    }

    public void addInning(Inning inning) {
        innings.add(inning);
    }
}
