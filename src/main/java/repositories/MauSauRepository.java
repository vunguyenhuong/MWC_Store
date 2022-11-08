package repositories;

import java.util.List;

import models.MauSac;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author tt
 */
public class MauSauRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<MauSac> getAllCV() {
        Query query = session.createQuery("SELECT m FROM MauSac m");
        List<MauSac> list = query.getResultList();
        return list;
    }

    public boolean save(MauSac ms) {
        try {
            transaction.begin();
            session.saveOrUpdate(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public MauSac getObj(String ma) {
        MauSac ms = null;
        try {
            Query query = session.createQuery("SELECT m FROM MauSac m WHERE m.Ma = :ma ");
            query.setParameter("ma", ma);
            ms = (MauSac) query.getSingleResult();
        } catch (Exception e) {
        }
        return ms;
    }
}
