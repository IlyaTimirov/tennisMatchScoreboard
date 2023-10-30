package servlet;

import model.Match;
import service.MatchService;
import service.OngoingMatchesService;
import service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/finish-match")
public class MatchFinishServlet extends BaseServlet{
    PlayerService playerService = new PlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        String uuid = req.getParameter("uuid");
        String winner = req.getParameter("winner");
        Match match = new Match();
        match.setPlayer1(ongoingMatchesService.getCurrentMatch(uuid).getPlayer1());
        match.setPlayer2(ongoingMatchesService.getCurrentMatch(uuid).getPlayer2());
        match.setWinner(playerService.getById(Integer.parseInt(winner)).get(0));
        MatchService matchService = new MatchService();
        matchService.save(match);
        req.setAttribute("player1", match.getPlayer1());
        req.setAttribute("player2", match.getPlayer2());
        req.setAttribute("winner", match.getWinner());
        req.getServletContext().getRequestDispatcher("/finish-match.jsp").forward(req, resp);
    }
}
