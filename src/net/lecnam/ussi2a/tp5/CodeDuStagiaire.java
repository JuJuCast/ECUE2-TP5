package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;

public class CodeDuStagiaire {

    public static void main(String[] args) {
        Bibliotheque bib = new Bibliotheque();

        Auteur hugo = new Auteur("Hugo", "Victor", LocalDate.of(1802, 2, 26));
        Auteur zola = new Auteur("Zola", "Émile", LocalDate.of(1840, 4, 2));
        Auteur verne = new Auteur("Verne", "Jules", LocalDate.of(1828, 2, 8));

        Livre miserables = new Livre(hugo, "Les Misérables", "9782070409228", 2);
        Livre germinal = new Livre(zola, "Germinal", "9782253004226", 1);
        Livre tourDuMonde = new Livre(verne, "Le Tour du monde en 80 jours", "9782253012696", 1);

        // Partie 4 : Utilisation de la méthode sécurisée ajouterLivre()
        testerAjout(bib, miserables);
        testerAjout(bib, germinal);
        testerAjout(bib, tourDuMonde);

        System.out.println("\n=== Étape 1 : état initial");
        bib.afficherLivres();

        System.out.println("\n=== Étape 2 : trois lecteurs empruntent Germinal");
        // Emprunt sécurisé direct sur l'objet Livre
        germinal.emprunter();
        germinal.emprunter();
        germinal.emprunter();
        System.out.println(germinal);

        // Partie 4 : Test de la méthode emprunter(isbn) de la bibliothèque
        System.out.println("\n--- Test emprunter par ISBN via la bibliothèque ---");
        testerEmprunt(bib, "9782070409228"); // Emprunt des Misérables (OK)
        testerEmprunt(bib, "9782253004226"); // Emprunt de Germinal (REFUSÉ : plus de disponible)

        System.out.println("\n=== Étape 3 : un auteur contemporain");
        try {
            Auteur inconnu = new Auteur("Dupont", "Jean", LocalDate.of(2090, 1, 1));
            System.out.println(inconnu);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur bloquée avec succès : " + e.getMessage());
        }

        System.out.println("\n=== Étape 4 : \"correction\" d'une faute de frappe");
        // tourDuMonde.isbn = "123";  --> N'existe plus (pas de setter d'ISBN)
        try {
            tourDuMonde.setTitre(null); // Tentative de titre invalide
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur bloquée avec succès : " + e.getMessage());
        }
        tourDuMonde.setTitre("Le Tour du monde en 80 jours (édition corrigée)");
        System.out.println(tourDuMonde);

        System.out.println("\n=== Étape 5 : \"petit ménage\" dans la bibliothèque");
        // bib.nbLivres = 1;  --> IMPOSSIBLE (nbLivres est private)
        bib.afficherLivres();
        testerAjout(bib, new Livre(hugo, "Notre-Dame de Paris", "9782253096337", 1));
        bib.afficherLivres();

        System.out.println("\n=== Étape 6 : on remplit tout");
        // bib.nbLivres = 100; --> IMPOSSIBLE (nbLivres est private)
        testerAjout(bib, new Livre(zola, "L'Assommoir", "9782070360024", 1));

        // Partie 4 : Test d'ajout d'un doublon ISBN
        System.out.println("\n--- Test refus de doublon ISBN ---");
        Livre doublon = new Livre(hugo, "Les Misérables (Doublon)", "9782070409228", 1);
        testerAjout(bib, doublon);

        // Partie 4 : Test de la méthode rendre(isbn) de la bibliothèque
        System.out.println("\n--- Test rendre par ISBN via la bibliothèque ---");
        testerRendre(bib, "9782253004226"); // Rendre Germinal (OK)
        testerRendre(bib, "9782253004226"); // Rendre Germinal à nouveau (REFUSÉ : stock plein)

        System.out.println("\n--- État final de la bibliothèque ---");
        bib.afficherLivres();

        System.out.println("\nFin du programme");
    }

    // --- Méthodes de test pour la Partie 4 ---

    private static void testerAjout(Bibliotheque bib, Livre livre) {
        if (bib.ajouterLivre(livre)) {
            System.out.println("[ACCEPTÉ] Livre ajouté : " + livre.getTitre());
        } else {
            System.out.println("[REFUSÉ] Impossible d'ajouter le livre : " + (livre != null ? livre.getTitre() : "null"));
        }
    }

    private static void testerEmprunt(Bibliotheque bib, String isbn) {
        if (bib.emprunter(isbn)) {
            System.out.println("[ACCEPTÉ] Emprunt réussi pour l'ISBN " + isbn);
        } else {
            System.out.println("[REFUSÉ] Emprunt impossible pour l'ISBN " + isbn);
        }
    }

    private static void testerRendre(Bibliotheque bib, String isbn) {
        if (bib.rendre(isbn)) {
            System.out.println("[ACCEPTÉ] Livre rendu pour l'ISBN " + isbn);
        } else {
            System.out.println("[REFUSÉ] Impossible de rendre le livre pour l'ISBN " + isbn);
        }
    }
}