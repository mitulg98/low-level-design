package org.example.service;

import org.example.Queue;
import org.example.models.match.Inning;
import org.example.models.match.Match;
import org.example.models.player.Team;

public class MatchHandler {
    public void startMatch(Match match) {
        InningHandler inningHandler = new InningHandler(match);

        int tossResult = doToss();
        Team tossWinner, tossLoser;

        if(tossResult == 1) {
            tossWinner = match.getFirstTeam();
            tossLoser = match.getSecondTeam();
        } else {
            tossWinner = match.getSecondTeam();
            tossLoser = match.getFirstTeam();
        }

        match.setTossWinner(tossWinner);

        match.addInning(new Inning(tossWinner, tossLoser, 1));
        match.addInning(new Inning(tossLoser, tossWinner, 2));

        match.getInnings().forEach(inningHandler::startInning);
    }

    public int doToss() {
        if(Math.random() < 0.5) {
            return 1;
        }
        return 2;
    }
}
