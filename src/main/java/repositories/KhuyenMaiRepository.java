
package repositories;

import java.util.List;
import models.KhuyenMai;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

import utilities.HibernateUtil;

/**
 *
 * @author KimChi
 */
public class KhuyenMaiRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<KhuyenMai> getAll() {
        Query query = session.createQuery("SELECT k FROM KhuyenMai k");
        List<KhuyenMai> list = query.getResultList();
        return list;
    }

    public List<KhuyenMai> findByName(String ten) {
        Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE k.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<KhuyenMai> list = query.getResultList();
        return list;
    }

    public boolean save(KhuyenMai km) {
        try {
            transaction.begin();
            session.saveOrUpdate(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }
    public boolean delete(KhuyenMai km) {
        try {
            transaction.begin();
            session.delete(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public KhuyenMai getObj(String ma) {
        KhuyenMai km = null;
        try {
            Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE k.ma = :ma");
            query.setParameter("ma", ma);
            km = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
        }
        return km;
    }

    public KhuyenMai getObjectById(int id) {
        KhuyenMai km = null;
        try {
            Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE n.id = :id");
            query.setParameter("id", id);
            km = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
        }
        return km;
    }
    public List<KhuyenMai> pagination(int pageNumber, int pageSize, String ten) {
        Query query = session.createQuery("SELECT n FROM KhuyenMai n WHERE n.ten like :ten");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        query.setParameter("ten", "%" + ten + "%");
        List<KhuyenMai> list = query.getResultList();
        return list;
    }
    public static void main(String[] args) {
        KhuyenMaiRepository kmr = new KhuyenMaiRepository();
        for (KhuyenMai khuyenMai : kmr.getAll()) {
            System.out.println(khuyenMai);
        }
    }

}
