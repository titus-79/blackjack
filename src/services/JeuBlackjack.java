package services;

import models.*;
import java.util.Scanner;

public class JeuBlackjack {
    private Paquet paquet;
    private Hand mainJoueur;
    private Hand mainCroupier;
    private Scanner scanner;
    
    public JeuBlackjack() {
        paquet = new Paquet();
        mainJoueur = new Hand();
        mainCroupier = new Hand();
        scanner = new Scanner(System.in);
    }
    
    public void jouer() {
        paquet.melanger();
        distribuerCartesInitiales();
        afficherMains(true);
        tourJoueur();
        if (mainJoueur.getScore() <= 21) {
        tourCroupier();
    }
        // 4. Déterminer le gagnant
    }
    
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
        while (mainJoueur.getScore() <= 21) {
        System.out.print("\nVoulez-vous (H)it ou (S)tand ? ");
        String choix = scanner.nextLine().trim().toUpperCase();
        
        if (choix.equals("H")) {
            mainJoueur.ajouterCarte(paquet.distribuerCarte());
            System.out.println("\nVotre main : " + mainJoueur + " (Score : " + mainJoueur.getScore() + ")");
            if (mainJoueur.getScore() > 21) {
                System.out.println("\nBUST ! Vous avez dépassé 21.");
                break;
                };
            
        } else if (choix.equals("S")) {
            System.out.println("\nVous restez à " + mainJoueur.getScore());
            break;
            
        } else {
            System.out.println("Choix invalide. Tapez H ou S.");
        }
    }
    }
    
    private void tourCroupier() {
    System.out.println("\n=== Tour du Croupier ===");
    
    // 1. Révéler la main complète
    System.out.println("Le croupier révèle sa main : " + mainCroupier + " (Score : " + mainCroupier.getScore() + ")");
    
    // 2. Appliquer la règle du 17
    while (mainCroupier.getScore() < 17) {
        Carte nouvelleCarte = paquet.distribuerCarte();
        mainCroupier.ajouterCarte(nouvelleCarte);
        System.out.println("Le croupier tire : " + nouvelleCarte + " (Score : " + mainCroupier.getScore() + ")");
}
    
    // 3. Afficher le résultat final
    if (mainCroupier.getScore() > 21) {
        System.out.println("Le croupier a BUST avec " + mainCroupier.getScore() + " !");
    } else {
        System.out.println("Le croupier reste à " + mainCroupier.getScore() + ".");
    }
}
    
    private void determinerGagnant() {
        // Comparer les scores
        // Afficher le résultat
    }
}