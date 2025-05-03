package test;

import dao2.UtilisateurDao;
import dao2.CategorieDao;
import dao2.ClubDao;
import dao2.DepenseDao;

import entities.Utilisateur;
import entities.Categorie;
import entities.Club;
import entities.Depense;

import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        UtilisateurDao utilisateurDao = new UtilisateurDao();
        CategorieDao categorieDao = new CategorieDao();
        ClubDao clubDao = new ClubDao();
        DepenseDao depenseDao = new DepenseDao();

        //  Éviter doublon utilisateur (en comparant les emails manuellement)
        boolean userExists = false;
        for (Utilisateur u : utilisateurDao.findAll()) {
            if ("soufiane@mail.com".equals(u.getEmail())) {
                userExists = true;
                break;
            }
        }
        Club club = clubDao.findById(1); // ou un club existant
        Date date = new Date();

        Utilisateur admin = new Utilisateur("Soufiane", "Test", "soufiane@mail.com", "admin123", "admin", date, club);

        if (!userExists) utilisateurDao.create(admin);

        //  Vérifier les catégories
        boolean cat1Exists = false, cat2Exists = false;
        for (Categorie c : categorieDao.findAll()) {
            if ("Matériel".equals(c.getNom())) cat1Exists = true;
            if ("Transport".equals(c.getNom())) cat2Exists = true;
        }
        Categorie cat1 = new Categorie("Matériel");
        if (!cat1Exists) categorieDao.create(cat1);
        Categorie cat2 = new Categorie("Transport");
        if (!cat2Exists) categorieDao.create(cat2);

        //  Vérifier les clubs
        boolean club1Exists = false, club2Exists = false;
        for (Club c : clubDao.findAll()) {
            if ("Club Robotique".equals(c.getNom())) club1Exists = true;
            if ("Club Science".equals(c.getNom())) club2Exists = true;
        }
        Club club1 = new Club("Club Robotique", 10000.0);
        if (!club1Exists) clubDao.create(club1);
        Club club2 = new Club("Club Science", 8000.0);
        if (!club2Exists) clubDao.create(club2);

        //  Vérifier les dépenses
        boolean dep1Exists = false, dep2Exists = false;
        for (Depense d : depenseDao.findAll()) {
            if ("Achat Arduino".equals(d.getLibelle())) dep1Exists = true;
            if ("Location Bus".equals(d.getLibelle())) dep2Exists = true;
        }
//        if (!dep1Exists) depenseDao.create(new Depense("Achat Arduino", 1200.0, new Date(), cat1, club1, admin));
//        if (!dep2Exists) depenseDao.create(new Depense("Location Bus", 600.0, new Date(), cat2, club2, admin));

        //  Affichage
        List<Depense> allDepenses = (List<Depense>) depenseDao.findAll();
        System.out.println("\n Dépenses (" + allDepenses.size() + ") :");
        allDepenses.stream().forEach((d) -> {
            System.out.println("- " + d.getLibelle() + " | " + d.getMontant() + " DH");
        });

        HibernateUtil.getSessionFactory().close();
    }
}
