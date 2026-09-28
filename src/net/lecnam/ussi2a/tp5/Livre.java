package net.lecnam.ussi2a.tp5;

/**
 * Code écrit par l'ancien stagiaire.
 */
public class Livre {
    private final Auteur auteur;
    private String titre;
    private final String isbn;
    private int nbExemplaires;
    private int nbDisponibles;

    public Livre(Auteur auteur, String titre, String isbn, int nbExemplaires) {
        this.auteur = auteur;
        this.isbn = isbn;
        this.nbExemplaires = nbExemplaires;
        this.nbDisponibles = nbExemplaires;

        if (auteur == null ){
            throw new IllegalArgumentException("L'auteur est obligatoire");
        }
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("L'ISBN est obligatoire");
        }
        if (nbExemplaires < 1) {
            throw new IllegalArgumentException("Un livre doit avoir au moins 1 exemplaire");
        }
        setTitre(titre);
    }

    public void setTitre(String titre) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre est obligatoire et ne peut pas être vide");
        }
        this.titre = titre;
    }
    public String toString() {
        return "[" + isbn + "] " + titre + " - " + auteur
                + " - " + nbDisponibles + "/" + nbExemplaires + " disponible(s)";
    }
    public boolean estDisponible() {
        return nbDisponibles > 0;
    }

    public boolean emprunter() {
        if (estDisponible()) {
            nbDisponibles--;
            return true;
        }
        return false;
    }


    public boolean rendre() {
        if (nbDisponibles < nbExemplaires) {
            nbDisponibles++;
            return true;
        }
        return false;
    }


    public boolean aLeMemeIsbnQue(Livre autre) {
        return autre != null && this.isbn.equals(autre.getIsbn());
    }

    public String getTitre(){
        return titre;
    }
    public Auteur getAuteur(){
        return auteur;
    }
    public String getIsbn(){
        return isbn;
    }
    public int getNbExemplaires(){
        return nbExemplaires;
    }
    public int getNbDisponibles(){
        return nbDisponibles;
    }
}
