package service;

import service.match.entity.CurrentMatch;

public class FinishedMatchesPersistenceService {
    public boolean isFinishedMatch(CurrentMatch currentMatch){
        return currentMatch.getScorePlayer1().getSeth() == 3
                || currentMatch.getScorePlayer2().getSeth() == 3;
    }
    public int getWinner(CurrentMatch currentMatch){
        int id = 0;
        if(currentMatch.getScorePlayer1().getSeth() == 3){
            id = currentMatch.getPlayer1().getId();
        }
        if(currentMatch.getScorePlayer2().getSeth() == 3){
            id = currentMatch.getPlayer2().getId();
        }
        return id;
    }
}
