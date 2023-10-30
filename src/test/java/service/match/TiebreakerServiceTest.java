package service.match;

import model.Player;
import org.junit.Assert;
import org.junit.Test;
import service.OngoingMatchesService;
import service.match.entity.Point;
import service.match.entity.ScoreBoard;

public class TiebreakerServiceTest {
    @Test
    public void tiebreaker(){
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        ongoingMatchesService.createNewGame("1", new Player(1, "i"), new Player(2, "s"));
        TiebreakerService tiebreakerService = new TiebreakerService();
        tiebreakerService.tiebreaker("1", 1);
        tiebreakerService.tiebreaker("1", 1);
        tiebreakerService.tiebreaker("1", 1);
        Assert.assertEquals("3", ongoingMatchesService.getCurrentMatch("1").getScorePlayer1().getPoint());
    }

    @Test
    public void trueTiebreaker(){
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        ongoingMatchesService.createNewGame("1", new Player(1, "i"), new Player(2, "s"));
        ongoingMatchesService.getCurrentMatch("1")
                .setScorePlayer1(new ScoreBoard(0,6, Point.EMPTY.getPoint()));
        ongoingMatchesService.getCurrentMatch("1")
                .setScorePlayer2(new ScoreBoard(0,6, Point.EMPTY.getPoint()));
        TiebreakerService tiebreakerService = new TiebreakerService();
        Assert.assertTrue(tiebreakerService.isTiebreaker("1"));
    }

    @Test
    public void falseTiebreaker(){
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        ongoingMatchesService.createNewGame("1", new Player(1, "i"), new Player(2, "s"));
        ongoingMatchesService.getCurrentMatch("1")
                .setScorePlayer1(new ScoreBoard(0,6, Point.EMPTY.getPoint()));
        ongoingMatchesService.getCurrentMatch("1")
                .setScorePlayer2(new ScoreBoard(0,5, Point.EMPTY.getPoint()));
        TiebreakerService tiebreakerService = new TiebreakerService();
        Assert.assertFalse(tiebreakerService.isTiebreaker("1"));
    }

}
