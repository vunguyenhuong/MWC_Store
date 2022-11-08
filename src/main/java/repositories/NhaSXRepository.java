package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.NhaSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

public class NhaSXRepository {

    private Session se = HibernateUtil.getSessionFactory().openSession();
    private Transaction tra = se.getTransaction();

    public List<NhaSX> getAll() {
        List<NhaSX> list = new ArrayList<>();
        Query query = se.createQuery("SELECT n FROM NhaSX n");
        list = query.getResultList();
        return list;
    }

    public List<NhaSX> search(String ma) {
        Query query = se.createQuery("SELECT n FROM NhaSX n WHERE n.ma like :Ma");
        query.setParameter("Ma", "%" + ma + "%");
        List<NhaSX> list = query.getResultList();
        list = query.getResultList();
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
}
