package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;
import java.time.Period;

/**
 * Code écrit par l'ancien stagiaire.
 * Il "marche"... à peu près.
 */
public class Auteur {
    public String nom;
    public String prenom;
    public LocalDate dateNaissance;

    public Auteur(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if (dateNaissance == null || dateNaissance.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de naissance est obligatoire et ne peut pas être dans le futur");
        }

    }
    public String toString() {
        int age = Period.between(dateNaissance, LocalDate.now()).getYears();
        return prenom + " " + nom + " (" + age + " ans)";
    }
    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
}
