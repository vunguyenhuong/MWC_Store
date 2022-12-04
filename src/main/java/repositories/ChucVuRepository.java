package repositories;

import java.util.List;
import javax.persistence.Query;
import models.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChucVuRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<ChucVu> getAll() {
        Query query = session.createQuery("SELECT c FROM ChucVu c");
        List<ChucVu> list = query.getResultList();
        return list;
    }
    public ChucVu getObjById(int id) {
        ChucVu d = null;
        try {
            Query query = session.createQuery("SELECT d FROM ChucVu d WHERE d.id = :id");
            query.setParameter("id", id);
            d = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
        }
        return d;
    }
}
