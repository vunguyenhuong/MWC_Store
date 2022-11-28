package repositories;

import java.util.List;
import models.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author homna
 */
public class KhachHangRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<KhachHang> getAll() {
        Query query = session.createQuery("SELECT kh FROM KhachHang kh");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public List<KhachHang> findByName(String ten) {
        Query query = session.createQuery("SELECT kh FROM KhachHang kh WHERE kh.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public boolean save(KhachHang kh) {
        try {
            transaction.begin();
            session.saveOrUpdate(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(KhachHang kh) {
        try {
            transaction.begin();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public KhachHang getObj(String ma) {
        KhachHang kh = null;
        try {
            Query query = session.createQuery("SELECT kh FROM KhachHang kh WHERE kh.ma = :ma");
            query.setParameter("ma", ma);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        return kh;
    }

    public KhachHang getObjectById(int id) {
        KhachHang kh = null;
        try {
            Query query = session.createQuery("SELECT kh FROM KhuyenMai kh WHERE kh.id = :id");
            query.setParameter("id", id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        return kh;
    }
    
    public List<KhachHang> findTop(int firstResult, int maxResult) {
        Query query = session.createQuery("SELECT kh FROM KhachHang kh ORDER BY kh.tongDiemTichLuy DESC");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        List<KhachHang> list = query.getResultList();
        return list;
    }
    
    public List<KhachHang> pagination(int pageNumber, int pageSize, String ten) {
        Query query = session.createQuery("SELECT n FROM KhachHang n WHERE n.ten like :ten");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        query.setParameter("ten", "%" + ten + "%");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        KhachHangRepository khr = new KhachHangRepository();
        for (KhachHang x : khr.findTop(0, 5)) {
            System.out.println(x);
        }
    }
}
