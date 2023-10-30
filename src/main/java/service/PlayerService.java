package service;

import dao.PlayerDao;
import model.Player;

import java.util.List;
import java.util.Optional;

public class PlayerService{
    private final PlayerDao playerDao = new PlayerDao();

    public void save(Player player) {
        playerDao.save(player);
    }

    public Optional<Player> getByName(String name) {
        return playerDao.getByName(name).isEmpty() ? Optional.empty() :
            Optional.of(playerDao.getByName(name).get(0));
    }

    public List<Player> getById(int id){
        return playerDao.getById(id);
    }
}
