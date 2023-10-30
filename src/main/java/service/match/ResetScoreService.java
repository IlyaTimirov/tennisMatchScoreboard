package service.match;

import service.match.entity.CurrentMatch;
import service.match.entity.Point;
import service.match.entity.ScoreBoard;

public class ResetScoreService {
    public void resetGame(CurrentMatch currentMatch, ScoreBoard scoreBoard, ScoreBoard scoreBoard1){
        scoreBoard.setGame(0);
        scoreBoard1.setGame(0);
        if(currentMatch.getScorePlayer1().equals(scoreBoard)){
            currentMatch.setScorePlayer1(scoreBoard);
            currentMatch.setScorePlayer2(scoreBoard1);
        }else {
            currentMatch.setScorePlayer2(scoreBoard);
            currentMatch.setScorePlayer1(scoreBoard1);
        }
    }
    public void resetPoints(CurrentMatch currentMatch, ScoreBoard scoreBoard, ScoreBoard scoreBoard1){
        scoreBoard.setPoint(Point.EMPTY.getPoint());
        scoreBoard1.setPoint(Point.EMPTY.getPoint());
        if(currentMatch.getScorePlayer1().equals(scoreBoard)){
            currentMatch.setScorePlayer1(scoreBoard);
            currentMatch.setScorePlayer2(scoreBoard1);
        }else {
            currentMatch.setScorePlayer2(scoreBoard);
            currentMatch.setScorePlayer1(scoreBoard1);
        }
    }
}
