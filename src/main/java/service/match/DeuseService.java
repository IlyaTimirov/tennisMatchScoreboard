package service.match;

import service.match.entity.Point;
import service.match.entity.ScoreBoard;

public class DeuseService {
    UpdateScoreService updateScore = new UpdateScoreService();
    public void deuse(ScoreBoard scoreBoard, ScoreBoard scoreBoard1){
        updateScore.setPoint(scoreBoard, Point.AD.getPoint());
        updateScore.setPoint(scoreBoard1, Point.EMPTY.getPoint());
    }
}
