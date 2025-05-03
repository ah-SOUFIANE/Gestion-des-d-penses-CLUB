package service;

import dao2.UtilisateurDao;
import entities.Utilisateur;
import java.util.List;

public class UtilisateurService {

    private final UtilisateurDao utilisateurDao;

    public UtilisateurService() {
        this.utilisateurDao = new UtilisateurDao();
    }

    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    public Utilisateur findById(int id) {
        return utilisateurDao.findById(id);
    }

    public void create(Utilisateur user) {
        utilisateurDao.create(user);
    }

    public void update(Utilisateur user) {
        utilisateurDao.update(user);
    }

    public void delete(Utilisateur user) {
        utilisateurDao.delete(user);
    }
}
