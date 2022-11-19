package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.ChiTietDep;
import models.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author KenTizz
 */
public class HoaDonCTRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery("SELECT h FROM HoaDonChiTiet h ");
        List<HoaDonChiTiet> hdct = new ArrayList<>();
        return hdct;
    }

    public boolean save(HoaDonChiTiet hdct) {
        try {
            transaction.begin();
            session.save(hdct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDonChiTiet hdct) {
        try {
            transaction.begin();
            session.delete(hdct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public HoaDonChiTiet getObjById(int id) {
        HoaDonChiTiet hdct = null;
        try {
            Query query = session.createQuery("SELECT c FROM HoaDonChiTiet c WHERE c.id = :id");
            query.setParameter("id", id);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
        }
        return hdct;
    }

    public List<HoaDonChiTiet> findByMa(String ma) {
        Query query = session.createQuery("SELECT c FROM HoaDonChiTiet c WHERE c.hoaDon.ma = :ma");
        query.setParameter("ma", ma);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }
    
    public HoaDonChiTiet getObj(int idSP, int idHD){
        HoaDonChiTiet hdct = null;
        try {
            Query query = session.createQuery("SELECT c FROM HoaDonChiTiet c WHERE c.ctdep.id = :idSP AND c.hoaDon.id = :idHD");
            query.setParameter("idSP", idSP);
            query.setParameter("idHD", idHD);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
        }
        return hdct;
    }
}
