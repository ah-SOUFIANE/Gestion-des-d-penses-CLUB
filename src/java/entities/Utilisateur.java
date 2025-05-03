package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findBetweenDate", query = "from Utilisateur where dateNaissance between :d1 and :d2"),
    @NamedQuery(name = "Utilisateur.findByClub", query = "from Utilisateur where club = :club")
})
@NamedNativeQuery(
    name = "Utilisateur.findDepenses",
    query = "SELECT d.* FROM depenses d " +
            "INNER JOIN utilisateurs u ON u.id = d.utilisateur_id " +
            "WHERE u.id = :id",
    resultClass = Depense.class
)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String role;

    private int etat;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private List<Depense> depenses;

    public Utilisateur() {}

    public Utilisateur(String nom, String prenom, String email, String motDePasse, String role, Date dateNaissance, Club club) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }
}
