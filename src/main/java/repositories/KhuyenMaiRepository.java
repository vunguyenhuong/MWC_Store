/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.util.List;
import models.KhuyenMai;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

import utilities.HibernateUtil;

/**
 *
 * @author KimChi
 */
public class KhuyenMaiRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<KhuyenMai> getAll() {
        Query query = session.createQuery("SELECT k FROM KhuyenMai k");
        List<KhuyenMai> list = query.getResultList();
        return list;
    }

    public List<KhuyenMai> findByName(String ten) {
        Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE k.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<KhuyenMai> list = query.getResultList();
        return list;
    }

    public boolean save(KhuyenMai km) {
        try {
            transaction.begin();
            session.saveOrUpdate(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public KhuyenMai getObj(String ma) {
        KhuyenMai km = null;
        try {
            Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            km = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
        }
        return km;
    }

    public KhuyenMai getObjectById(int id) {
        KhuyenMai km = null;
        try {
            Query query = session.createQuery("SELECT k FROM KhuyenMai k WHERE n.id = :id");
            query.setParameter("id", id);
            km = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
        }
        return km;
    }

    public static void main(String[] args) {
        KhuyenMaiRepository kmr = new KhuyenMaiRepository();
        for (KhuyenMai khuyenMai : kmr.getAll()) {
            System.out.println(khuyenMai);
        }
    }

}
