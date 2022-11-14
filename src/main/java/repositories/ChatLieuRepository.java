package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.ChatLieu;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author cvdoa
 */
public class ChatLieuRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<ChatLieu> getAll() {
        Query query = session.createQuery("SELECT c FROM ChatLieu c");
        List<ChatLieu> list = query.getResultList();
        return list;
    }

    public boolean save(ChatLieu cl) {
        try {
            transaction.begin();
            session.saveOrUpdate(cl);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(ChatLieu cl) {
        try {
            transaction.begin();
            session.delete(cl);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public ChatLieu getObj(String ma) {
        ChatLieu s = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChatLieu c WHERE c.ma = :ma ");
            query.setParameter("ma", ma);
            s = (ChatLieu) query.getSingleResult();
        } catch (Exception e) {
        }
        return s;
    }

    public List<ChatLieu> findByName(String ten) {
        List<ChatLieu> list = new ArrayList<>();
        Query query = session.createQuery("SELECT c FROM ChatLieu c WHERE c.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        list = query.getResultList();
        return list;
    }
    
    public ChatLieu getObjById(int id) {
        ChatLieu cl = null;
        try {
            Query query = session.createQuery("SELECT cl FROM ChatLieu cl WHERE cl.id = :id");
            query.setParameter("id", id);
            cl = (ChatLieu) query.getSingleResult();
        } catch (Exception e) {
        }
        return cl;
    }
    
    
}
