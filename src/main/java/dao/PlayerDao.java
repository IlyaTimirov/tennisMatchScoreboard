package dao;

import model.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerDao{

    public void save(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Player> getByName(String name) {
        List<Player> players = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            players = session.createQuery("from Player where name= :name", Player.class)
                    .setParameter("name", name)
                    .getResultList();
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return players;
    }

    public List<Player> getById(int id) {
        List<Player> players = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            players = session.createQuery("from Player where id= :id", Player.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return players;
    }
}
