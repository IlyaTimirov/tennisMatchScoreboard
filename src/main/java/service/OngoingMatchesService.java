package service;

import model.Player;
import service.match.entity.CurrentMatch;
import service.match.entity.Point;
import service.match.entity.ScoreBoard;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private static OngoingMatchesService instance;
    private OngoingMatchesService(){}

    public static OngoingMatchesService getInstance(){
        if (instance == null){
            instance = new OngoingMatchesService();
        }
        return instance;
    }

    public static final int ZERO = 0;
    Map<String, CurrentMatch> ongoingMatches = new ConcurrentHashMap<>();

    public void createNewGame(String uuid, Player player1, Player player2){
        CurrentMatch currentMatch = new CurrentMatch();
        currentMatch.setPlayer1(player1);
        currentMatch.setPlayer2(player2);
        currentMatch.setScorePlayer1(new ScoreBoard(ZERO,ZERO, Point.EMPTY.getPoint()));
        currentMatch.setScorePlayer2(new ScoreBoard(ZERO,ZERO,Point.EMPTY.getPoint()));
        putCurrentMatches(uuid, currentMatch);
    }
    private void putCurrentMatches(String uuid, CurrentMatch currentMatch){
        ongoingMatches.put(uuid, currentMatch);
    }

    public CurrentMatch getCurrentMatch(String uuid){
        return ongoingMatches.get(uuid);
    }
}

