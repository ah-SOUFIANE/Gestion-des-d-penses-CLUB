package service;

import dao2.IDao;
import entities.Utilisateur;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public class ServiceUtilisateur implements IDao<Utilisateur> {

    @Override
    public boolean create(Utilisateur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Utilisateur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Utilisateur o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

   @Override
public Utilisateur findById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Utilisateur u = (Utilisateur) session.get(Utilisateur.class, id);
    session.getTransaction().commit();
    session.close();
    return u;
}


  @Override
public List<Utilisateur> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Utilisateur> utilisateurs = session.createQuery("from Utilisateur").list();
    session.getTransaction().commit();
    session.close();
    return utilisateurs;
}


    public Utilisateur getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Utilisateur> result = session.createQuery("from Utilisateur where email = ?")
            .setParameter(0, email)
            .list();
        session.getTransaction().commit();
        session.close();
        return result.isEmpty() ? null : result.get(0);
    }
}
