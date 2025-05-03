package service;

import dao2.CategorieDao;
import entities.Categorie;

import java.util.List;

public class CategorieService {

    private final CategorieDao categorieDao;

    public CategorieService() {
        this.categorieDao = new CategorieDao();
    }

    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }

    public void update(Categorie cat) {
        categorieDao.update(cat); // ✅ Correction ici
    }

    public Categorie findById(int id) {
        return categorieDao.findById(id); // ✅ Correction ici
    }

    public void create(Categorie cat) {
        categorieDao.create(cat); // ✅ Correction ici
    }

    public void delete(Categorie cat) {
        categorieDao.delete(cat); // ✅ Correction ici
    }
}
