package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import models.ChiTietDep;
import models.HoaDonChiTiet;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.IChiTietDepService;
import services.impl.ChiTietDepService;
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

    public HoaDonChiTiet getObj(int idSP, int idHD) {
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
    
    public List<HoaDonChiTiet> findByTTHDCT(int trangThaiHDCT){
        Query query = session.createQuery("SELECT h FROM HoaDonChiTiet h WHERE h.trangThai = :trangThai");
        query.setParameter("trangThai", trangThaiHDCT);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }

    public List<HoaDonChiTiet> getDoanhThu(int trangThai, Date ngayThanhToan) {
        Query query = session.createQuery("SELECT h FROM HoaDonChiTiet h WHERE h.hoaDon.trangThai= :trangThai AND h.hoaDon.ngayThanhToan LIKE :ngayThanhToan");
        query.setParameter("trangThai", trangThai);
        query.setParameter("ngayThanhToan", ngayThanhToan);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }

    public List<HoaDonChiTiet> findByTT(int trangThaiHD) {
        Query query = session.createQuery("SELECT h FROM HoaDonChiTiet h WHERE h.hoaDon.trangThai = :trangThai");
        query.setParameter("trangThai", trangThaiHD);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }

    public List findSP(int trangThai) {
        String sql = "SELECT TOP 5 IDCTD,COUNT(SOLUONG) FROM HOADONCHITIET A "
                + "JOIN HOADON B ON A.IdHD = B.ID WHERE B.TrangThai = ? "
                + "GROUP BY IDCTD ORDER BY COUNT(SOLUONG) DESC";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(1, trangThai);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List list = query.list();
        return list;
    }

    public List<ChiTietDep> findTop5SP() {
//        SELECT c FROM ChiTietDep c WHERE c.id IN (SELECT h FROM HoaDonChiTiet h ORDER BY COUNT(h.soLuong) DESC)
        Query query = session.createQuery("SELECT f.ctdep.id FROM HoaDonChiTiet f GROUP BY f.hoaDon.ma");
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public List<ChiTietDep> sptheothang(Date date) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.id IN"
                + "(SELECT h.ctdep.id FROM HoaDonChiTiet h WHERE h.hoaDon.id IN"
                + "(SELECT hd FROM HoaDon hd WHERE hd.ngayThanhToan LIKE :ngayThanhToan))");
        query.setParameter("ngayThanhToan", date+"%");
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        HoaDonCTRepository hdctr = new HoaDonCTRepository();
        IChiTietDepService iChiTietDepService = new ChiTietDepService();
        String dateString = "2022-11";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM").parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonCTRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ChiTietDep x: hdctr.sptheothang(date)) {
            System.out.println(x);
        }
//        System.out.println(hdctr.findSP(1));
    }
}
