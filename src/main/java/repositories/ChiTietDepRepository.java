package repositories;

import java.util.List;
import javax.persistence.Query;
import models.ChiTietDep;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import utilities.HibernateUtil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChiTietDepRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<ChiTietDep> getAll() {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c");
        List<ChiTietDep> list = query.getResultList();
        return list;
//return session.createCriteria(ChiTietDep.class).list();
    }

    public boolean save(ChiTietDep ctd) {
        try {
            transaction.begin();
            session.save(ctd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(ChiTietDep ctd) {
        try {
            transaction.begin();
            session.delete(ctd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<ChiTietDep> findByTT(int trangThai, String ten, String typeOderBy) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.trangThai = :trangThai AND c.dep.ten LIKE :ten ORDER BY c.soLuong " + typeOderBy);
        query.setParameter("trangThai", trangThai);
        query.setParameter("ten", "%" + ten + "%");
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public List<ChiTietDep> findSLSPLess(int soLuong) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.soLuong <= :soLuong");
        query.setParameter("soLuong", soLuong);
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public ChiTietDep getObjById(int id) {
        ChiTietDep ctd = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.id = :id");
            query.setParameter("id", id);
            ctd = (ChiTietDep) query.getSingleResult();
        } catch (Exception e) {
        }
        return ctd;
    }

    public ChiTietDep getObjByMa(String ma) {
        ChiTietDep ctd = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.dep.ma = :ma");
            query.setParameter("ma", ma);
            ctd = (ChiTietDep) query.getSingleResult();
        } catch (Exception e) {
        }
        return ctd;
    }

    public ChiTietDep checkDuplicate(int idDep, int idLoaiDep, int idMauSac, int idChatLieu, int idNSX, int idSize) {
        ChiTietDep ctd = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.dep.id = :idDep AND c.loaiDep.id = :idLoaiDep AND c.mauSac.Id = :idMauSac AND c.chatLieu.id = :idChatLieu AND c.nhaSX.id = :idNSX AND c.size.id = :idSize");
            query.setParameter("idDep", idDep);
            query.setParameter("idLoaiDep", idLoaiDep);
            query.setParameter("idMauSac", idMauSac);
            query.setParameter("idChatLieu", idChatLieu);
            query.setParameter("idNSX", idNSX);
            query.setParameter("idSize", idSize);
            ctd = (ChiTietDep) query.getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return ctd;
    }

    public List<ChiTietDep> topSPBanChay(int firstResult, int maxResult) {
//        NativeQuery query = session.createNativeQuery("SELECT * FROM CHITIETDEP WHERE ID IN "
//                + "(SELECT TOP 5 IDCTD FROM HOADONCHITIET A JOIN HOADON B "
//                + "ON A.IdHD = B.ID WHERE B.TrangThai = 1 "
//                + "GROUP BY IDCTD ORDER BY COUNT(SOLUONG) DESC)", ChiTietDep.class);
        Query query = session.createQuery("SELECT c FROM ChiTietDep c ORDER BY c.soLuongBanRa DESC");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public List<ChiTietDep> filter(String tenDep, String tenLoaiDep, String tenMauSac, String tenChatLieu) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c "
                + " WHERE (c.dep.ten LIKE :tenDep or :tenDep is null or :tenDep = '')"
                + " AND (c.mauSac.ten = :tenMauSac or :tenMauSac is null or :tenMauSac = '')"
                + " AND (c.chatLieu.ten = :tenChatLieu or :tenChatLieu is null or :tenChatLieu = '')"
                + " AND (c.loaiDep.ten = :tenLoaiDep or :tenLoaiDep is null or :tenLoaiDep = '')");
        query.setParameter("tenDep", "%" + tenDep + "%");
        query.setParameter("tenMauSac", tenMauSac);
        query.setParameter("tenChatLieu", tenChatLieu);
        query.setParameter("tenLoaiDep", tenLoaiDep);
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public List<ChiTietDep> pagination(int pageNumber, int pageSize, String tenDep, String tenLoaiDep, String tenMauSac, String tenChatLieu) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c "
                + " WHERE (c.dep.ten LIKE :tenDep or :tenDep is null or :tenDep = '')"
                + " AND (c.mauSac.ten = :tenMauSac or :tenMauSac is null or :tenMauSac = '')"
                + " AND (c.chatLieu.ten = :tenChatLieu or :tenChatLieu is null or :tenChatLieu = '')"
                + " AND (c.loaiDep.ten = :tenLoaiDep or :tenLoaiDep is null or :tenLoaiDep = '')");
        query.setParameter("tenDep", "%" + tenDep + "%");
        query.setParameter("tenMauSac", tenMauSac);
        query.setParameter("tenChatLieu", tenChatLieu);
        query.setParameter("tenLoaiDep", tenLoaiDep);
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        ChiTietDepRepository ctdr = new ChiTietDepRepository();
        try {
            System.out.println(ctdr.pagination(1, 1000, "", "", "", "").size());
        } catch (Exception e) {
        }
    }
}
