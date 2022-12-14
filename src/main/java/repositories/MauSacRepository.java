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
public class MauSacRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<MauSac> getAll() {
        Query query = session.createQuery("SELECT m FROM MauSac m ORDER BY m.ngaySuaCuoi DESC");
        List<MauSac> list = query.getResultList();
        return list;
    }

    public List<MauSac> findByName(String ten) {
        Query query = session.createQuery("SELECT n FROM MauSac n WHERE n.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
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
        MauSac n = null;
        try {
            Query query = session.createQuery("SELECT n FROM MauSac n WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            n = (MauSac) query.getSingleResult();
        } catch (Exception e) {
        }
        return n;
    }

    public MauSac getObjectById(int id) {
        MauSac n = null;
        try {
            Query query = session.createQuery("SELECT n FROM MauSac n WHERE n.id = :id");
            query.setParameter("id", id);
            n = (MauSac) query.getSingleResult();
        } catch (Exception e) {
        }
        return n;
    }

    public List<MauSac> pagination(int pageNumber, int pageSize, String ten) {
        Query query = session.createQuery("SELECT n FROM MauSac n WHERE n.ten like :ten ORDER BY n.ngaySuaCuoi DESC");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        query.setParameter("ten", "%" + ten + "%");
        List<MauSac> list = query.getResultList();
        return list;
    }
}
