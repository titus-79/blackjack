package services;

import models.*;
import java.util.Scanner;

public class JeuBlackjack {
    // Attributs
    private Paquet paquet;
    private Hand mainJoueur;
    private Hand mainCroupier;
    private Scanner scanner;
    
    // Constructeur
    public JeuBlackjack() {
        // Initialiser paquet, mains, scanner
        paquet = new Paquet();
        mainJoueur = new Hand();
        mainCroupier = new Hand();
        scanner = new Scanner(System.in);
    }
    
    // Méthode principale
    public void jouer() {
        paquet.melanger();
        // 1. Distribuer les cartes initiales
        distribuerCartesInitiales();
        afficherMains(true);
        // 2. Tour du joueur
        // 3. Tour du croupier
        // 4. Déterminer le gagnant
    }
    
    // Méthodes privées pour organiser le code
    private void distribuerCartesInitiales() {
              for (int i = 0; i < 2; i++) {
            mainJoueur.ajouterCarte(paquet.distribuerCarte());
            mainCroupier.ajouterCarte(paquet.distribuerCarte());
        }
    }
    
    private void afficherMains(boolean cacherCarteCroupier) {
        System.out.println("\n=== BLACKJACK ===\n");
        System.out.println("Carte du Joueur : " + mainJoueur + " (Score : " + mainJoueur.getScore() + ")");
        if (cacherCarteCroupier && mainCroupier.getNombreCartes() > 0) {
            System.out.println("Cartes du croupier : " + mainCroupier.getCarte(0) + ", [CARTE CACHÉE]");
        } else {
            System.out.println("Carte du Croupier : " + mainCroupier + " (Score : " + mainCroupier.getScore() + ")");
        }
    }
    
    private void tourJoueur() {
        // Boucle : demander Hit ou Stand
        // Si Hit, distribuer une carte
        // Vérifier si bust (> 21)
    }
    
    private void tourCroupier() {
        // Règle : tirer tant que score < 17
    }
    
    private void determinerGagnant() {
        // Comparer les scores
        // Afficher le résultat
    }
}