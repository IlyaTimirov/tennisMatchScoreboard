package servlet;

import model.Match;
import service.MatchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/matches")
public class MatchesServlet extends BaseServlet {
    MatchService matchService = new MatchService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int currentPage;
        int recordsPerPage = 2;
        long rows;
        List<Match> matches;
        String name = req.getParameter("filter_by_player_name");
        currentPage = req.getParameter("page") == null ? 1
                : Integer.parseInt(req.getParameter("page"));
        matches = isNotNullAndNotEmptyName(name)
                ? matchService.findByName(name.toUpperCase(), currentPage, recordsPerPage)
                : matchService.findAll(currentPage, recordsPerPage);
        rows = matchService.getNumberOfRows(name);
        int nOfPages = (int) rows / recordsPerPage;
        if(nOfPages % recordsPerPage > 0){
            nOfPages++;
        }
        req.setAttribute("matches", matches);
        req.setAttribute("nOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", recordsPerPage);
        req.setAttribute("filter_by_player_name", name);
        req.getServletContext().getRequestDispatcher("/matches.jsp").forward(req, resp);
    }

    private boolean isNotNullAndNotEmptyName(String name){
        return name != null && !name.isEmpty();
    }
}
