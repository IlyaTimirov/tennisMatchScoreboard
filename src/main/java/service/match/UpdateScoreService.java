package service.match;

import service.match.entity.CurrentMatch;
import service.match.entity.ScoreBoard;

public class UpdateScoreService {
    ResetScoreService resetScore = new ResetScoreService();
    public void setPoint(ScoreBoard scoreBoard, String point){
        scoreBoard.setPoint(point);
    }
    public void setGame(CurrentMatch currentMatch, ScoreBoard scoreBoard){
        int currentScore = scoreBoard.getGame();
        currentScore++;
        scoreBoard.setGame(currentScore);
        checkWinSet(currentMatch);
    }

    public void setSeth(ScoreBoard seth){
        int currentSeth = seth.getSeth();
        currentSeth++;
        seth.setSeth(currentSeth);
    }

    public boolean isWinSet(ScoreBoard scoreBoard){
        return scoreBoard.getGame() == 7;
    }
    public void checkWinSet(CurrentMatch currentMatch){
        if(isWinSet(currentMatch.getScorePlayer1())){
            setSeth(currentMatch.getScorePlayer1());
            resetScore.resetGame(currentMatch, currentMatch.getScorePlayer1(), currentMatch.getScorePlayer2());
        }
        if(isWinSet(currentMatch.getScorePlayer2())){
            setSeth(currentMatch.getScorePlayer2());
            resetScore.resetGame(currentMatch, currentMatch.getScorePlayer1(), currentMatch.getScorePlayer2());
        }
    }
}
