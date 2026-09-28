package net.lecnam.ussi2a.tp5;

/**
 * Code écrit par l'ancien stagiaire (modifié et encapsulé).
 */
public class Bibliotheque {
    private Livre[] livres = new Livre[100];
    private int nbLivres = 0;

    public Bibliotheque() {
    }

    public Bibliotheque(int capacite) {
        if (capacite < 1) {
            capacite = 10;
        }
        this.livres = new Livre[capacite];
        this.nbLivres = 0;
    }

    public int getNbLivres() {
        return this.nbLivres;
    }

    public boolean estPleine() {
        return this.nbLivres >= this.livres.length;
    }

    public boolean ajouterLivre(Livre livre) {
        if (livre == null || livre.getIsbn() == null) {
            return false;
        }
        if (estPleine()) {
            return false;
        }
        if (rechercherLivre(livre.getIsbn()) != null) {
            return false;
        }
        this.livres[this.nbLivres] = livre;
        this.nbLivres++;
        return true;
    }

    public Livre rechercherLivre(String isbn) {
        if (isbn == null) {
            return null;
        }
        for (int i = 0; i < this.nbLivres; i++) {
            if (isbn.equalsIgnoreCase(this.livres[i].getIsbn())) {
                return this.livres[i];
            }
        }
        return null;
    }

    public boolean emprunter(String isbn) {
        Livre livre = rechercherLivre(isbn);
        if (livre == null) {
            return false;
        }
        return livre.emprunter();
    }

    public boolean rendre(String isbn) {
        Livre livre = rechercherLivre(isbn);
        if (livre == null) {
            return false;
        }
        return livre.rendre();
    }

    public void afficherLivres() {
        System.out.println("--- " + nbLivres + " livre(s) dans la bibliothèque ---");
        for (int i = 0; i < nbLivres; i++) {
            System.out.println(livres[i]);
        }
    }

    @Override
    public String toString() {
        return "Bibliothèque : " + this.nbLivres + "/" + this.livres.length + " livres";
    }
}