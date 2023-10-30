package service;

import dao.MatchDao;
import model.Match;

import java.util.List;

public class MatchService {
    MatchDao matchDao = new MatchDao();
    public void save(Match match){
        matchDao.save(match);
    }
    public List<Match> findAll(int currentPage, int recordsPerPage){
        return matchDao.findAll(currentPage, recordsPerPage);
    }

    public List<Match> findByName(String name, int currentPage, int recordsPerPage){
        return matchDao.findByName(name, currentPage, recordsPerPage);
    }
    public Long getNumberOfRows(String name){
        return matchDao.getNumberOfRows(name);
    }
}
