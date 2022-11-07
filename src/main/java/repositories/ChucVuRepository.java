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

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<ChucVu> getAll() {
        Query query = session.createQuery("SELECT c FROM ChucVu c");
        List<ChucVu> list = query.getResultList();
        return list;
    }
}
