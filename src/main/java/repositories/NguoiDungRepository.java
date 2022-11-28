package repositories;

import java.util.List;
import javax.persistence.Query;
import models.NguoiDung;
import org.bridj.cpp.std.list;
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

    public List<NguoiDung> getListNhanVien(String ma) {
        Query query = session.createQuery(" SELECT n FROM NguoiDung n WHERE n.chucVu.ma = :ma ");
        query.setParameter("ma", ma);
        List<NguoiDung> list = query.getResultList();
        return list;
    }

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

    public List<NguoiDung> findByName(String ma, String ten) {
        Query query = session.createQuery(" SELECT n FROM NguoiDung n WHERE n.chucVu.ma = :ma AND n.ten LIKE :ten ");
        query.setParameter("ma", ma);
        query.setParameter("ten", "%" + ten + "%");
        List<NguoiDung> list = query.getResultList();
        return list;
    }

    public List<NguoiDung> pagination(String ma, int pageNumber, int pageSize, String ten) {
        Query query = session.createQuery("SELECT c FROM NguoiDung c WHERE c.chucVu.ma = :ma AND c.ten LIKE :ten ");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        query.setParameter("ma", ma);
        query.setParameter("ten", "%" + ten + "%");
        List<NguoiDung> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        NguoiDungRepository ndr = new NguoiDungRepository();
        for (NguoiDung x : ndr.getListNhanVien("CV1")) {
            System.out.println(x);
        }
    }

}
