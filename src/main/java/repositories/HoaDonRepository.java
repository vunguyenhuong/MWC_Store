package repositories;

import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
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

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<HoaDon> getAll() {
        Query query = session.createQuery("SELECT h FROM HoaDon h ORDER BY h.id DESC");
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public boolean save(HoaDon hd) {
        try {
            transaction.begin();
            session.saveOrUpdate(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDon hd) {
        try {
            transaction.begin();
            session.delete(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public HoaDon getObj(String ma) {
        HoaDon hd = null;
        try {
            Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.ma = :ma");
            query.setParameter("ma", ma);
            hd = (HoaDon) query.getSingleResult();

        } catch (Exception e) {
        }
        return hd;
    }

    public HoaDon getObjById(int id) {
        HoaDon hd = null;
        try {
            Query query = session.createQuery(" SELECT d FROM HoaDon d WHERE d.id = :id ");
            query.setParameter("id", id);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
        }
        return hd;
    }

    public List<HoaDon> findByName(String ma) {
        Query query = session.createQuery(" SELECT hd FROM HoaDon hd WHERE hd.ma like :ma ");
        query.setParameter("ma", "%" + ma + "%");
        List<HoaDon> list1 = query.getResultList();
        return list1;
    }

    public List<HoaDon> getObjByMaAndKH(String ten) {
        Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.ma = :ten or h.khachHang.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<HoaDon> list2 = query.getResultList();

        return list2;
    }

    public List<HoaDon> getHDByKH(String type) {
        Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.khachHang" + type);
        List<HoaDon> list3 = query.getResultList();

        return list3;
    }

    public List<HoaDon> getHDByTT2(int trangthai, String typeKH, Date from, Date to) {
        Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.trangThai = :trangthai AND h.ngayTao BETWEEN :from AND :to AND h.khachHang " + typeKH);
        query.setParameter("trangthai", trangthai);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<HoaDon> list4 = query.getResultList();

        return list4;
    }

    public List<HoaDon> getByTT(int trangThai) {
        Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai");
        query.setParameter("trangThai", trangThai
        );
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        HoaDonRepository hdr = new HoaDonRepository();
        for (HoaDon x : hdr.getByTT(1)) {
            System.out.println(x);
        }
    }
}
