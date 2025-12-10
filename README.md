# Blackjack - Jeu de Cartes en Java

Un jeu de Blackjack complet en console, développé en Java avec une architecture orientée objet propre et des fonctionnalités avancées.

---

## Table des matières

- [À propos](#à-propos)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Structure du projet](#structure-du-projet)
- [Installation et lancement](#installation-et-lancement)
- [Règles du jeu](#règles-du-jeu)
- [Démonstration](#démonstration)
- [Ce que j'ai appris](#ce-que-jai-appris)
- [Auteur](#auteur)

---

## À propos

Ce projet a été développé dans le cadre de mon parcours vers une certification CDA (Concepteur Développeur d'Applications).

L'objectif était de créer un jeu de Blackjack fonctionnel en appliquant les principes de la programmation orientée objet, tout en implémentant des fonctionnalités avancées comme la gestion automatique des As, un système de mise avec jetons, et des statistiques de jeu.

---

## Fonctionnalités

### Fonctionnalités principales

- **Jeu complet de Blackjack** : Toutes les règles classiques du casino
- **Gestion intelligente des As** : Valeur automatique (11 ou 1) selon le score
- **Tour du croupier automatisé** : Suit la règle stricte du 17
- **Détection du Blackjack naturel** : Distinction entre 21 naturel (2 cartes) et 21 normal
- **Système de mise** : Gestion de jetons avec gains/pertes
- **Parties multiples** : Possibilité de rejouer sans relancer le programme
- **Statistiques détaillées** : Suivi des victoires, défaites, égalités et taux de victoire

### Détails techniques

- **Mélange aléatoire** du paquet à chaque partie
- **Validation des entrées utilisateur** (mise, choix Hit/Stand)
- **Calcul des gains** :
  - Victoire normale : +1x la mise
  - Blackjack naturel : +1.5x la mise (paiement 3:2)
  - Push (égalité) : récupération de la mise
- **Fin automatique** si le joueur n'a plus de jetons

---

## Technologies utilisées

- **Langage** : Java 17
- **Paradigme** : Programmation Orientée Objet (POO)
- **Collections** : ArrayList, énumérations (enum)
- **Entrées/Sorties** : Scanner pour interaction console
- **Gestion aléatoire** : Collections.shuffle()

### Concepts Java mis en œuvre

- Classes et objets
- Encapsulation (attributs privés, getters)
- Héritage et polymorphisme (toString())
- Énumérations (enum) pour les couleurs et valeurs
- Collections (ArrayList)
- Boucles (for, while, for-each)
- Conditions complexes et logique métier
- Gestion des exceptions (NumberFormatException)
- Packages et organisation du code

---

## Structure du projet

```
blackjack/
├── src/
│   ├── models/                # Classes métier
│   │   ├── Carte.java         # Représentation d'une carte
│   │   ├── Couleur.java       # Enum des couleurs (Pique, Cœur, etc.)
│   │   ├── Valeur.java        # Enum des valeurs (As, Roi, etc.)
│   │   ├── Paquet.java        # Gestion du deck de 52 cartes
│   │   └── Hand.java          # Gestion d'une main de cartes
│   ├── services/              # Logique métier
│   │   └── JeuBlackjack.java  # Orchestration du jeu
│   └── Main.java              # Point d'entrée
└── README.md
```

### Architecture

Le projet suit une **architecture en couches** :

- **models/** : Représente les entités métier (Carte, Main, Paquet)
- **services/** : Contient la logique du jeu (règles, tours, statistiques)
- **Main.java** : Lance l'application

Cette séparation respecte le principe de **séparation des responsabilités** (SRP).

---

## Installation et lancement

### Prérequis

- Java 17 ou supérieur
- Un terminal/console

### Étapes

1. **Cloner le projet**
   ```bash
   git clone https://github.com/titus-79/blackjack.git
   cd blackjack
   ```

2. **Compiler le projet**
   ```bash
   javac -d bin src/**/*.java src/*.java
   ```

3. **Lancer le jeu**
   ```bash
   java -cp bin Main
   ```

### Utilisation avec un IDE

- **IntelliJ IDEA / Eclipse / VS Code** : Ouvrez le projet et exécutez `Main.java`

---

## Règles du jeu

### Objectif

Obtenir une main dont la valeur est la plus proche de **21** sans dépasser ce chiffre.

### Valeurs des cartes

- **As** : 1 ou 11 (ajusté automatiquement)
- **Figures** (Valet, Dame, Roi) : 10
- **Autres cartes** : Valeur faciale (2-10)

### Déroulement

1. **Mise** : Le joueur mise des jetons (solde initial : 1000)
2. **Distribution** : 2 cartes pour le joueur, 2 pour le croupier (1 cachée)
3. **Tour du joueur** :
   - **Hit (H)** : Tirer une carte
   - **Stand (S)** : Rester avec sa main actuelle
   - **Bust** : Si le score dépasse 21, le joueur perd immédiatement
4. **Tour du croupier** :
   - Tire obligatoirement jusqu'à atteindre au moins 17
   - S'arrête dès 17 ou plus
5. **Résolution** :
   - Score le plus proche de 21 gagne
   - Blackjack naturel (As + Figure) bat un 21 normal
   - Égalité = Push (récupération de la mise)

---

## Démonstration

### Exemple de partie

```
Solde actuel : 1000 jetons
Combien voulez-vous miser ? 100

=== BLACKJACK ===

Carte du Joueur : As de Pique, Sept de Cœur (Score : 18)
Cartes du croupier : Roi de Trèfle, [CARTE CACHÉE]

Voulez-vous (H)it ou (S)tand ? s

Vous restez à 18

=== Tour du Croupier ===
Le croupier révèle sa main : Roi de Trèfle, Cinq de Carreau (Score : 15)
Le croupier tire : Trois de Pique (Score : 18)
Le croupier reste a 18.

=== RÉSULTAT ===
PUSH ! Égalité avec 18 points.
Vous récupérez votre mise de 100 jetons.
Votre score : 18 | Croupier : 18

=== STATISTIQUES ===
Solde      : 1000 jetons
Victoires  : 0
Défaites   : 0
Égalités   : 1
─────────────────────────
Total      : 1 parties
Taux       : 0.0%

Voulez vous rejouer?(O/N)
```

---

## Ce que j'ai appris

### Compétences techniques

- **Conception orientée objet** : Modélisation d'entités métier avec classes et enums
- **Algorithmes** : Implémentation du mélange de cartes, calcul de score avec contraintes
- **Gestion d'état** : Suivi du solde, des statistiques, des mains
- **Validation des entrées** : Gestion robuste des inputs utilisateur
- **Architecture logicielle** : Séparation models/services, organisation en packages

### Concepts Java maîtrisés

- **Enums** : Pour représenter des données fixes (couleurs, valeurs)
- **Collections** : Manipulation d'ArrayList (ajout, retrait, parcours)
- **Boucles avancées** : for-each, while avec conditions complexes
- **Gestion des exceptions** : Try-catch pour les erreurs de parsing
- **StringBuilder** : Optimisation de la concaténation de chaînes
- **Formatage** : printf pour affichage précis (pourcentages)

---

## Auteur

**Rodolphe Legeron**

- Développeur Java Junior en reconversion professionnelle
- DWWM certifié | CDA en cours
- Niort, France
- [LinkedIn](https://www.linkedin.com/in/rodolphe-legeron-624338369)
- [GitHub](https://github.com/titus-79)

---

## Licence

Ce projet est sous licence MIT. Vous êtes libre de l'utiliser, le modifier et le distribuer.

---

## Remerciements

- La communauté Java pour la documentation
- Les contributeurs open-source pour l'inspiration

---

**Si ce projet vous plaît, n'hésitez pas à lui donner une étoile sur GitHub !**

---