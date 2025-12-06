package services;

import models.*;
import java.util.Scanner;

public class JeuBlackjack {
    private Paquet paquet;
    private Hand mainJoueur;
    private Hand mainCroupier;
    private Scanner scanner;
    private int countWin;
    private int countLose;
    private int countPush;
    private int countGame;

    public JeuBlackjack() {
        paquet = new Paquet();
        mainJoueur = new Hand();
        mainCroupier = new Hand();
        scanner = new Scanner(System.in);
        countWin = 0;
        countLose = 0;
        countPush = 0;
        countGame = 0;
    }

    public void jouerUnePartie() {
        paquet.melanger();
        distribuerCartesInitiales();
        afficherMains(true);
        tourJoueur();
        if (mainJoueur.getScore() <= 21) {
            tourCroupier();
        }
        determinerGagnant();
    }

    private void distribuerCartesInitiales() {
        for (int i = 0; i < 2; i++) {
            mainJoueur.ajouterCarte(paquet.distribuerCarte());
            mainCroupier.ajouterCarte(paquet.distribuerCarte());
        }
        // // Test Blackjack joueur
        // mainJoueur.ajouterCarte(new Carte(Couleur.PIQUE, Valeur.AS));
        // mainJoueur.ajouterCarte(new Carte(Couleur.COEUR, Valeur.ROI));

        // // Main normale croupier
        // mainCroupier.ajouterCarte(new Carte(Couleur.COEUR, Valeur.ROI));
        // mainCroupier.ajouterCarte(new Carte(Couleur.PIQUE, Valeur.AS));
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
                }
                ;

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
        System.out
                .println("Le croupier révèle sa main : " + mainCroupier + " (Score : " + mainCroupier.getScore() + ")");

        while (mainCroupier.getScore() < 17) {
            Carte nouvelleCarte = paquet.distribuerCarte();
            mainCroupier.ajouterCarte(nouvelleCarte);
            System.out.println("Le croupier tire : " + nouvelleCarte + " (Score : " + mainCroupier.getScore() + ")");
        }

        if (mainCroupier.getScore() > 21) {
            System.out.println("Le croupier a BUST avec " + mainCroupier.getScore() + " !");
        } else {
            System.out.println("Le croupier reste a " + mainCroupier.getScore() + ".");
        }
    }

    private void determinerGagnant() {
        System.out.println("\n=== RÉSULTAT ===");
        countGame++;
        int scoreJoueur = mainJoueur.getScore();
        int scoreCroupier = mainCroupier.getScore();
        boolean joueurBlackjack = mainJoueur.estBlackjackNaturel();
        boolean croupierBlackjack = mainCroupier.estBlackjackNaturel();

        if (scoreJoueur > 21) {
            System.out.println("Le croupier a gagné ! (Vous avez bust)");
            countLose++;
        } else if (scoreCroupier > 21) {
            if (joueurBlackjack) {
                System.out.println("BLACKJACK NATUREL ! Vous avez gagné avec un 21 naturel !");
            } else {
                System.out.println("Vous avez gagné ! (Le croupier a bust)");
            }
            countWin++;
        } else if (joueurBlackjack && croupierBlackjack) {
            System.out.println("PUSH ! Les deux ont un Blackjack naturel !");
            countPush++;
        } else if (joueurBlackjack) {
            System.out.println("BLACKJACK NATUREL ! Vous avez gagné avec un 21 naturel !");
            countWin++;
        } else if (croupierBlackjack) {
            System.out.println("Le croupier a gagné avec un Blackjack naturel !");
            countLose++;
        } else if (scoreJoueur > scoreCroupier) {
            System.out.println("Vous avez gagné avec un score de " + scoreJoueur + " points !");
            countWin++;
        } else if (scoreCroupier > scoreJoueur) {
            System.out.println("Le croupier a gagné avec un score de " + scoreCroupier + " points.");
            countLose++;
        } else {
            System.out.println("PUSH ! Égalité avec " + scoreJoueur + " points.");
            countPush++;
        }

        System.out.println("Votre score : " + scoreJoueur + " | Croupier : " + scoreCroupier);
        System.out.println("=== STATISTIQUES ===");
        System.out.println("Victoires : " + countWin);
        System.out.println("Défaites : " + countLose);
        System.out.println("Égalités : " + countPush);
        System.out.println("─".repeat(25));
        System.out.println("Total parties : " + countGame + " parties");
        double tauxVictoire = (countGame > 0) ? (countWin * 100.0 / countGame) : 0;
        System.out.printf("Taux de victoire : %.1f%%\n", tauxVictoire);

    }

    public void reinitialiser() {
        mainJoueur.vider();
        mainCroupier.vider();
        paquet = new Paquet();
        paquet.melanger();
    }

    public void jouerPlusieurParties() {
        boolean continuer = true;
        while (continuer) {
            jouerUnePartie();
            System.out.println("Voulez vous rejouer?(O/N)");
            String choix = scanner.nextLine().trim().toUpperCase();

            if (choix.equals("O")) {
                System.out.println("\n" + "=".repeat(50));
                System.out.println("    NOUVELLE PARTIE");
                System.out.println("=".repeat(50));
                reinitialiser();

            } else if (choix.equals("N")) {
                continuer = false;
                System.out.println("Merci d'avoir joué ! À bientôt !");
                scanner.close();

            } else {
                System.out.println("Choix invalide. Tapez O ou N.");
            }
        }
    }

}