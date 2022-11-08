package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.Size;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author cvdoa
 */
public class SizeRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<Size> getAll() {
        Query query = session.createQuery("SELECT s FROM Size s");
        List<Size> list = query.getResultList();
        return list;
    }

    public boolean save(Size size) {
        try {
            transaction.begin();
            session.saveOrUpdate(size);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Size size) {
        try {
            transaction.begin();
            session.delete(size);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Size getObject(String ma) {
        Size s = null;
        try {
            Query query = session.createQuery("SELECT s FROM Size s WHERE s.ma = :ma ");
            query.setParameter("ma", ma);
            s = (Size) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<Size> getSearch(String ten) {
        List<Size> list = new ArrayList<>();
        Query query = session.createQuery("SELECT s FROM Size s WHERE s.ma LIKE :ma");
        query.setParameter("ma", "%" + ten + "%");
        list = query.getResultList();
        return list;
    }
}
