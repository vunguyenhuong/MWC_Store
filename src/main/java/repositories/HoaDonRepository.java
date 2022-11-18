package repositories;

import java.util.List;
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
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<HoaDon> getAll() {
        Query query = session.createQuery("SELECT h FROM HoaDon h");
        List<HoaDon> list = query.getResultList();
        return list;
    }
    public boolean save(HoaDon hd){
        try {
            transaction.begin();
            session.saveOrUpdate(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }
    
    public boolean delete(HoaDon hd){
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
    
    public HoaDon getObj(String ma){
        HoaDon hd = null;
        try {
            Query query = session.createQuery(" SELECT h FROM HoaDon h WHERE h.ma = :ma");
            query.setParameter("ma", ma);
            hd = (HoaDon) query.getSingleResult();
            
        } catch (Exception e) {
        }
        return hd;
    }
    
    public HoaDon getObjById(int id){
        HoaDon hd = null;
        try {
            Query query = session.createQuery(" SELECT d FROM HoaDon d WHERE d.id = :id ");
            query.setParameter("id", id);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
        }
        return hd;
    }
    public List<HoaDon> findByName(String ma){
        Query query = session.createQuery(" SELECT hd FROM HoaDon hd WHERE hd.ma like :ma ");
        query.setParameter("ma","%" + ma + "%");
        List<HoaDon> list1 = query.getResultList();
        return list1;
    }
    public static void main(String[] args) {
        HoaDonRepository hdr = new HoaDonRepository();
        for (HoaDon x : hdr.getAll()) {
            System.out.println(x);
        }
    }
}
