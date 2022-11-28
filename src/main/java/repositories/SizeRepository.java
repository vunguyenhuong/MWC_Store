package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.Size;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author cvdoa
 */
public class SizeRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
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
//            e.printStackTrace();
        }
        return s;
    }

    public List<Size> findByName(Float ten) {
        List<Size> list = new ArrayList<>();
        Query query = session.createQuery("SELECT s FROM Size s WHERE s.kichCo LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        list = query.getResultList();
        return list;
    }

    public Size getObjById(int id) {
        Size sz = null;
        try {
            Query query = session.createQuery("SELECT sz FROM Size sz WHERE sz.id = :id ");
            query.setParameter("id", id);
            sz = (Size) query.getSingleResult();
        } catch (Exception e) {
        }
        return sz;
    }

    public List<Size> pagination(int pageNumber, int pageSize) {
        Query query = session.createQuery(" SELECT s FROM Size s");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        List<Size> list = query.getResultList();
        return list;
    }

}
