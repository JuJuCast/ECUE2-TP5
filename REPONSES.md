# TP5 : Réponses

Nom / Prénom :

## Partie 1 : Enquête

| Étape | Ce qui est anormal                                               | Ligne responsable | Classe qui aurait dû l'empêcher                                   |
|-------|------------------------------------------------------------------|-------------------|-------------------------------------------------------------------|
| 1     | Tous les auteurs s'appelent                                      |public static String nom;| Ne pas mettre statique                                            |
| 2     | Probleme sur le nombre de livres dispo                           |this.nbDisponibles = nbExemplaires;| Ne pas se tromper de nombre                                       |
| 3     | La date de naissance de l'auteur est en 20290 d'ou le -63 ans    |Auteur inconnu = new Auteur("Dupont", "Jean", LocalDate.of(2090, 1, 1));| Ne pas mettre 2090 ou empecher les dates supérieures à aujourd'hui |
| 4     | On ne devrait pas pouvoir changer les valeurs comme ça           |tourDuMonde.titre = null;| Changer les infos directement dans la déclaration                 |
| 5     | Il ne calcule pas le nombre de livres mais il le défnit en dur   |bib.nbLivres = 1;| Comptrer le nombre de livres pour le compteur                     |
| 6     | Il utilise pas le nombre d'exemplaire et defnit le nombre en dur |  bib.ajouterLivre(new Livre(zola, "L'Assommoir", "9782070360024", 1));| Utiliser les focntions qu'il a déja|

**1.1** :
Tous les auteurs s'appelent Verne car c'est le dernier à être défnit et dans la classe le nom de l'auteur est défnit en statique et donc il ne change plus.

**1.2** :
Le problème se trouve souvent entre le fauteuil et l'écran :)

## Partie 2

**2.1** :

**2.2** :

## Partie 3

**3.1** :

**3.2** :

## Partie 4

**4.1** :

**4.2** :

## Partie 5

**5.1** :

**5.2** :

**5.3** :

**5.4** :

**5.5** :

## Partie 6

Nombre de livres créés affiché à l'étape 10, et explication :

## Bonus B2 : code dupliqué

