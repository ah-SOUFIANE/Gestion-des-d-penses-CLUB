package service;

import dao2.DepenseDao;
import entities.Depense;
import java.util.List;

public class DepenseService {

    private final DepenseDao dao = new DepenseDao(); // ✅ Nom correct utilisé partout

    public List<Depense> findAll() {
        return dao.findAll();
    }

    public List<Depense> findByUtilisateur(int idUtilisateur) {
        return dao.findByUtilisateur(idUtilisateur);
    }

     public boolean create(Depense depense) {
        return dao.create(depense); // ✅ méthode déjà existante dans DepenseDao
    }
}
