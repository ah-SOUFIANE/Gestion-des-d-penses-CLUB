package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private double budget;

    public Club() {
    }

    public Club(String nom, double budget) {
        this.nom = nom;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getBudget() {
        return budget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
