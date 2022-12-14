package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.NhaSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

public class NhaSXRepository {

    private static final Session se = HibernateUtil.getSessionFactory().openSession();
    private Transaction tra = se.getTransaction();

    public List<NhaSX> getAll() {
        Query query = se.createQuery("SELECT n FROM NhaSX n ORDER BY n.ngaySuaCuoi DESC");
        List<NhaSX> list = query.getResultList();
        return list;
    }

    public List<NhaSX> findByName(String ten) {
        Query query = se.createQuery("SELECT n FROM NhaSX n WHERE n.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<NhaSX> list = query.getResultList();
        return list;
    }

    public boolean save(NhaSX nsx) {
        try {
            tra.begin();
            se.saveOrUpdate(nsx);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(NhaSX nsx) {
        try {
            tra.begin();
            se.delete(nsx);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public NhaSX getObj(String ma) {
        NhaSX nx = null;
        try {
            Query query = se.createQuery("SELECT n FROM NhaSX n WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            nx = (NhaSX) query.getSingleResult();
        } catch (Exception e) {
        }
        return nx;
    }

    public NhaSX getObjById(int id) {
        NhaSX nsx = null;
        try {
            Query query = se.createQuery(" SELECT s FROM NhaSX s WHERE s.id = :id ");
            query.setParameter("id", id);
            nsx = (NhaSX) query.getSingleResult();
        } catch (Exception e) {
        }
        return nsx;
    }

    public List<NhaSX> pagination(int pageNumber, int pageSize, String ten) {
        Query query = se.createQuery("SELECT n FROM NhaSX n WHERE n.ten like :ten ORDER BY n.ngaySuaCuoi DESC");
        int pageIndex = pageNumber - 1 < 0 ? 0 : pageNumber - 1;
        int fromRecordIndex = pageIndex * pageSize;
        query.setFirstResult(fromRecordIndex);
        query.setMaxResults(pageSize);
        query.setParameter("ten", "%" + ten + "%");
        List<NhaSX> list = query.getResultList();
        return list;
    }
}
