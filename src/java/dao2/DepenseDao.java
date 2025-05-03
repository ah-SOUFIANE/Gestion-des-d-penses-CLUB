package dao2;

import entities.Depense;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class DepenseDao extends AbstractDao<Depense> {

    public DepenseDao() {
        super(Depense.class);
    }

    @Override
    public boolean create(Depense depense) {
        boolean success = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(depense);
            session.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }

    @SuppressWarnings("unchecked")
    public List<Depense> findByUtilisateur(int idUtilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Depense> list = session
                .createQuery("from Depense where utilisateur.id = :id")
                .setParameter("id", idUtilisateur)
                .list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Depense> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Depense> list = session.createQuery("from Depense").list();
        session.close();
        return list;
    }
}
