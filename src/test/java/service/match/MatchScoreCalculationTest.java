package service.match;

import model.Player;
import org.junit.Assert;
import org.junit.Test;
import service.OngoingMatchesService;

public class MatchScoreCalculationTest {
    @Test
    public void calculationMatchScore(){
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        ongoingMatchesService.createNewGame("1", new Player(1, "i"), new Player(2, "s"));
        MatchScoreCalculationService calculation = new MatchScoreCalculationService();
        calculation.calculationMatchScore("1", 1);
        calculation.calculationMatchScore("1", 1);
        Assert.assertEquals("30", ongoingMatchesService.getCurrentMatch("1").getScorePlayer1().getPoint());
    }
}
