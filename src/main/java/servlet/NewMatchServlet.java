package servlet;

import model.Player;
import service.OngoingMatchesService;
import service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class NewMatchServlet extends BaseServlet {
    private final PlayerService playerService = new PlayerService();
    private final OngoingMatchesService matchesService = OngoingMatchesService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String player1 = req.getParameter("player1").toUpperCase();
        String player2 = req.getParameter("player2").toUpperCase();
        Player firstPlayer = new Player(player1);
        Player secondPlayer = new Player(player2);
        if(playerService.getByName(player1).isEmpty()){
            playerService.save(firstPlayer);
        }
        firstPlayer = playerService.getByName(player1).get();
        if(playerService.getByName(player2).isEmpty()){
            playerService.save(secondPlayer);
        }
        secondPlayer = playerService.getByName(player2).get();
        String uuid = UUID.randomUUID().toString();
        matchesService.createNewGame(uuid, firstPlayer, secondPlayer);
        resp.sendRedirect("/match-score?uuid=" + uuid);
    }
}
