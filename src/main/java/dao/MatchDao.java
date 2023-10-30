package dao;

import model.Match;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MatchDao{

    public void save(Match match){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(match);
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Match> findByName(String name, int currentPage, int recordsPerPage){
        List<Match> matches = new ArrayList<>();
        Transaction transaction = null;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            matches = session.createQuery("from Match where player1.name= :name or player2.name= :name", Match.class)
                    .setParameter("name", name)
                    .setParameter("name", name)
                    .setFirstResult(start)
                    .setMaxResults(recordsPerPage)
                    .getResultList();
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return matches;
    }

    public List<Match> findAll(int currentPage, int recordsPerPage) {
        List<Match> matches = new ArrayList<>();
        Transaction transaction = null;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            matches = session.createQuery("from Match", Match.class)
                    .setFirstResult(start)
                    .setMaxResults(recordsPerPage)
                    .getResultList();
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return matches;
    }
    public Long getNumberOfRows(String name) {
        Transaction transaction = null;
        Long result = 0L;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            if(isNotNullAndNotEmptyName(name)){
                name = name.toUpperCase();
                result = session.
                        createQuery("select count(id) from Match where player1.name= :name or player2.name= :name", Long.class)
                        .setParameter("name", name)
                        .setParameter("name", name)
                        .getSingleResult();
            }else {
                result = session.
                        createQuery("select count(id) from Match", Long.class).getSingleResult();
            }
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    private boolean isNotNullAndNotEmptyName(String name){
        return name != null && !name.isEmpty();
    }
}
