package repositories;

import java.util.List;
import models.Dep;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author dell
 */
public class DepRepository {

    private Session session = utilities.HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<Dep> getAll() {
        Query query = session.createQuery("SELECT d FROM Dep d");
        List<Dep> list = query.getResultList();
        return list;
    }

    public boolean save(Dep dep) {
        try {
            transaction.begin();
            session.saveOrUpdate(dep);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Dep getObj(String ma) {
        Dep dep = null;

        try {
            Query query = session.createQuery("SELECT d FROM Dep d WHERE d.ma = :ma");
            query.setParameter("ma", ma);
            dep = (Dep) query.getSingleResult();
        } catch (Exception e) {
        }
        return dep;
    }
}
