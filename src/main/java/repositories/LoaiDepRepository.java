package repositories;

import java.util.List;
import javax.persistence.Query;
import models.LoaiDep;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author homna
 */
public class LoaiDepRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<LoaiDep> getAll() {
        Query query = session.createQuery("SELECT c FROM LoaiDep c");
        List<LoaiDep> list = query.getResultList();
        return list;
    }

    public boolean save(LoaiDep ld) {
        try {
            transaction.begin();
            session.saveOrUpdate(ld);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public LoaiDep getObj(String ma) {
        LoaiDep ld = null;
        try {
            Query query = session.createQuery("SELECT n FROM LoaiDep n WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            ld = (LoaiDep) query.getSingleResult();
        } catch (Exception e) {
        }
        return ld;
    }

    public List<LoaiDep> findByName(String ten) {
        Query query = session.createQuery("SELECT n FROM LoaiDep n WHERE n.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<LoaiDep> list = query.getResultList();
        return list;
    }

    public LoaiDep getObjectById(int id) {
        LoaiDep ld = null;
        try {
            Query query = session.createQuery("SELECT n FROM LoaiDep n WHERE n.id = :id");
            query.setParameter("id", id);
            ld = (LoaiDep) query.getSingleResult();
        } catch (Exception e) {
        }
        return ld;
    }

}
