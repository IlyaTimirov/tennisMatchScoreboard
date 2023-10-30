package service.match;

import service.OngoingMatchesService;
import service.match.entity.CurrentMatch;
import service.match.entity.ScoreBoard;

public class TiebreakerService {
    OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
    MatchScoreCalculationService calculationService = new MatchScoreCalculationService();
    UpdateScoreService updateScore = new UpdateScoreService();
    ResetScoreService resetScore = new ResetScoreService();
    public boolean isTiebreaker(String uuid){
        CurrentMatch currentMatch = ongoingMatchesService.getCurrentMatch(uuid);
        return currentMatch.getScorePlayer1().getGame() == 6
                && currentMatch.getScorePlayer2().getGame() == 6;
    }

    public void tiebreaker(String uuid, int id){
        CurrentMatch currentMatch = ongoingMatchesService.getCurrentMatch(uuid);
        calculationService.settingZeroPoints(currentMatch);
        ScoreBoard scoreBoard;
        if(currentMatch.getPlayer1().getId() == id){
            scoreBoard = currentMatch.getScorePlayer1();
        }else {
            scoreBoard = currentMatch.getScorePlayer2();
        }
        int score = Integer.parseInt(scoreBoard.getPoint());
        score++;
        updateScore.setPoint(scoreBoard, String.valueOf(score));
        updateScore.checkWinSet(currentMatch);
        if(isWinTiebreaker(currentMatch)){
            resetScore.resetPoints(currentMatch, currentMatch.getScorePlayer1(), currentMatch.getScorePlayer2());
        }
    }
    private boolean isWinTiebreaker(CurrentMatch currentMatch){
        int scorePlayer1 = Integer.parseInt(currentMatch.getScorePlayer1().getPoint());
        int scorePlayer2 = Integer.parseInt(currentMatch.getScorePlayer2().getPoint());
        if(scorePlayer1 >= 7 || scorePlayer2 >= 7){
            if((scorePlayer1 - scorePlayer2) >= 2){
                updateScore.setGame(currentMatch, currentMatch.getScorePlayer1());
                return true;
            }
            if((scorePlayer2 - scorePlayer1) >= 2){
                updateScore.setGame(currentMatch, currentMatch.getScorePlayer2());
                return true;
            }
        }
        return false;
    }
}
