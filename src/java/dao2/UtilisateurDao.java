package dao2;

import entities.Utilisateur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class UtilisateurDao extends AbstractDao<Utilisateur> {

    public UtilisateurDao() {
        super(Utilisateur.class);
    }

    // ✅ Trouver par ID
    public Utilisateur findById(int id) {
        Session session = null;
        Utilisateur user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (Utilisateur) session.get(Utilisateur.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return user;
    }

    // ✅ Créer un utilisateur
  @Override
public boolean create(Utilisateur user) {
    Session session = null;
    Transaction tx = null;
    boolean success = false;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        success = true;
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return success;
}


    // ✅ Mettre à jour un utilisateur
    @Override
public boolean update(Utilisateur user) {
    Session session = null;
    Transaction tx = null;
    boolean success = false;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        success = true;
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return success;
}

    

    // ✅ Supprimer un utilisateur
   @Override
public boolean delete(Utilisateur user) {
    Session session = null;
    Transaction tx = null;
    boolean success = false;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        success = true;
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return success;
}


    // ✅ Trouver par email
    public Utilisateur findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        Utilisateur utilisateur = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateur = (Utilisateur) session
                .createQuery("from Utilisateur where email = :email")
                .setParameter("email", email)
                .uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return utilisateur;
    }

    // ✅ Trouver tous les utilisateurs avec un rôle
    public List<Utilisateur> findByRole(String role) {
        Session session = null;
        Transaction tx = null;
        List<Utilisateur> utilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session
                .createQuery("from Utilisateur where role = :role")
                .setParameter("role", role)
                .list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return utilisateurs;
    }

   public Utilisateur findByEmailAndPassword(String email, String hashedPassword) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Utilisateur user = null;

    try {
        user = (Utilisateur) session.createQuery(
                "FROM Utilisateur WHERE email = :email AND motDePasse = :password")
                .setParameter("email", email)
                .setParameter("password", hashedPassword)
                .uniqueResult();
    } catch (Exception e) {
    } finally {
        session.close();
    }

    return user;
}

}
