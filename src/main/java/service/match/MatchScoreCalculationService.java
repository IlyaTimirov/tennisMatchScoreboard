package service.match;

import service.OngoingMatchesService;
import service.match.entity.CurrentMatch;
import service.match.entity.Point;
import service.match.entity.ScoreBoard;

public class MatchScoreCalculationService {
    OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
    DeuseService deuse = new DeuseService();
    ResetScoreService resetScore = new ResetScoreService();
    UpdateScoreService updateScore = new UpdateScoreService();
    public void settingZeroPoints(CurrentMatch currentMatch){
        if(currentMatch.getScorePlayer1().getPoint().equals(Point.EMPTY.getPoint())
                && currentMatch.getScorePlayer2().getPoint().equals(Point.EMPTY.getPoint())){
            updateScore.setPoint(currentMatch.getScorePlayer1(), Point.LOVE.getPoint());
            updateScore.setPoint(currentMatch.getScorePlayer2(), Point.LOVE.getPoint());
        }
    }
    public void calculationMatchScore(String uuid, int id){
        CurrentMatch currentMatch = ongoingMatchesService.getCurrentMatch(uuid);
        settingZeroPoints(currentMatch);
        ScoreBoard scoreBoard;
        ScoreBoard scoreBoard1;
        if(currentMatch.getPlayer1().getId() == id){
            scoreBoard = currentMatch.getScorePlayer1();
            scoreBoard1 = currentMatch.getScorePlayer2();
        }else {
            scoreBoard = currentMatch.getScorePlayer2();
            scoreBoard1 = currentMatch.getScorePlayer1();
        }
        switch (scoreBoard.getPoint()){
            case "0" -> updateScore.setPoint(scoreBoard, Point.FIFTEEN.getPoint());
            case "15" -> updateScore.setPoint(scoreBoard, Point.THIRTY.getPoint());
            case "30" -> updateScore.setPoint(scoreBoard, Point.FORTY.getPoint());
            case "40" -> {
                if(scoreBoard.getPoint().equals(scoreBoard1.getPoint())){
                    deuse.deuse(scoreBoard, scoreBoard1);
                }else {
                    updateScore.setGame(currentMatch, scoreBoard);
                    resetScore.resetPoints(currentMatch, scoreBoard, scoreBoard1);
                }
            }
            case " " -> {
                updateScore.setPoint(scoreBoard, Point.FORTY.getPoint());
                updateScore.setPoint(scoreBoard1, Point.FORTY.getPoint());
            }
            case "AD" -> {
                updateScore.setGame(currentMatch, scoreBoard);
                resetScore.resetPoints(currentMatch, scoreBoard, scoreBoard1);
            }
        }
    }
}
