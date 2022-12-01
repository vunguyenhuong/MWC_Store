package repositories;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import models.HoaDon;
import models.KhachHang;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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

    public List<HoaDon> filter(String tenNguoiDung, Date from, Date to, int trangThai) {
        String hql;
        if (trangThai == -1) {
            hql = "SELECT h FROM HoaDon h WHERE h.nguoiDung.ten LIKE :tenNguoiDung AND h.ngayTao BETWEEN :from AND :to ";
        } else {
            hql = "SELECT h FROM HoaDon h WHERE h.nguoiDung.ten LIKE :tenNguoiDung AND h.ngayTao BETWEEN :from AND :to AND h.trangThai = :trangThai";
        }
        Query query = session.createQuery(hql);
        query.setParameter("tenNguoiDung", "%" + tenNguoiDung + "%");
        query.setParameter("from", from);
        query.setParameter("to", to);
        if (trangThai == 0 || trangThai == 1 || trangThai == 2) {
            query.setParameter("trangThai", trangThai);
        }
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public List<HoaDon> getByTT(int trangThai) {
        Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai ORDER BY h.id DESC");
        query.setParameter("trangThai", trangThai);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public BigDecimal doanhThuTheoThang(int thang, int nam) {
        String sql = "SELECT CAST(SUM(TongTien) AS DECIMAL(20,0)) FROM HOADON\n"
                + "WHERE YEAR(NGAYTHANHTOAN) = ? AND MONTH(NgayThanhToan) = ?";
        NativeQuery query = session.createNativeQuery(sql);
        query.setParameter(1, nam);
        query.setParameter(2, thang);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal doanhThuTheoNgay(int ngay, int thang, int nam) {
        String sql = "SELECT CAST(SUM(TongTien) AS DECIMAL(20,0)) FROM HOADON\n"
                + "WHERE YEAR(NGAYTHANHTOAN) = ? AND MONTH(NGAYTHANHTOAN) = ? AND DAY(NGAYTHANHTOAN) = ?";
        NativeQuery query = session.createNativeQuery(sql);
        query.setParameter(1, nam);
        query.setParameter(2, thang);
        query.setParameter(3, ngay);
        return (BigDecimal) query.getSingleResult();
    }

    public static void main(String[] args) throws ParseException {
        HoaDonRepository hdr = new HoaDonRepository();
        BigDecimal bigDecimal = hdr.doanhThuTheoNgay(29, 11, 2022);
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-30");
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-30");
        for (HoaDon hoaDon : hdr.filter("", from, to,0)) {
            System.out.println(hoaDon);
        }
        System.out.println(hdr.filter("", from, to,0).size());
    }
}
