package repositories;

import java.util.List;
import models.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class HoaDonRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<HoaDon> getAll() {
        Query query = session.createQuery("SELECT h FROM HoaDon h");
        List<HoaDon> list = query.getResultList();
        return list;
    }
    
    public static void main(String[] args) {
        HoaDonRepository hdr = new HoaDonRepository();
        for (HoaDon x : hdr.getAll()) {
            System.out.println(x);
        }
    }
}
