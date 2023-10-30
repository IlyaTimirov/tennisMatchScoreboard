package servlet;


import service.FinishedMatchesPersistenceService;
import service.match.MatchScoreCalculationService;
import service.OngoingMatchesService;
import service.match.TiebreakerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends BaseServlet {
    private final OngoingMatchesService matches = OngoingMatchesService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        req.setAttribute("player1", matches.getCurrentMatch(uuid).getPlayer1());
        req.setAttribute("player2", matches.getCurrentMatch(uuid).getPlayer2());
        req.setAttribute("scoreBoardPlayer1", matches.getCurrentMatch(uuid).getScorePlayer1());
        req.setAttribute("scoreBoardPlayer2", matches.getCurrentMatch(uuid).getScorePlayer2());
        req.setAttribute("uuid", uuid);
        req.getServletContext().getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        MatchScoreCalculationService calculation = new MatchScoreCalculationService();
        TiebreakerService tiebreaker = new TiebreakerService();
        FinishedMatchesPersistenceService fin = new FinishedMatchesPersistenceService();
        String uuid = req.getParameter("uuid");
        String id = req.getParameter("id");
        if(tiebreaker.isTiebreaker(uuid)){
            tiebreaker.tiebreaker(uuid, Integer.parseInt(id));
        }else {
            calculation.calculationMatchScore(uuid, Integer.parseInt(id));
        }
        if(fin.isFinishedMatch(matches.getCurrentMatch(uuid))){
            resp.sendRedirect("/finish-match?uuid=" + uuid + "&winner=" + id);
            return;
        }
        doGet(req, resp);
    }
}
