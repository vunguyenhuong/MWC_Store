package repositories;

import java.util.List;
import javax.persistence.Query;
import models.NguoiDung;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class NguoiDungRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<NguoiDung> getAll() {
        Query query = session.createQuery("SELECT n FROM NguoiDung n");
        List<NguoiDung> list = query.getResultList();
        return list;
    }

    public boolean save(NguoiDung nd) {
        try {
            transaction.begin();
            session.saveOrUpdate(nd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(NguoiDung nd) {
        try {
            transaction.begin();
            session.delete(nd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public NguoiDung getObj(String ma) {
        NguoiDung nd = null;
        try {
            Query query = session.createQuery("SELECT n FROM NguoiDung n WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            nd = (NguoiDung) query.getSingleResult();
        } catch (Exception e) {
        }
        return nd;
    }
    
    public static void main(String[] args) {
        NguoiDungRepository ndr = new NguoiDungRepository();
        for (NguoiDung x : ndr.getAll()) {
            System.out.println(x);
        }
    }
}
