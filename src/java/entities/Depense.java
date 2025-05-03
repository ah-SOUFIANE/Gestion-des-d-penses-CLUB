package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "depense")
public class Depense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private double montant;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Depense() {}

    public Depense(Utilisateur utilisateur, Club club, String libelle, double montant, Date date, Categorie categorie) {
        this.utilisateur = utilisateur;
        this.club = club;
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    // Méthodes utiles
    public String getCategorieNom() {
        return categorie != null ? categorie.getNom() : "";
    }

    public int getUtilisateurId() {
        return utilisateur != null ? utilisateur.getId() : 0;
    }

    public int getClubId() {
        return club != null ? club.getId() : 0;
    }
}
