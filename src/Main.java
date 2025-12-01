import models.Carte;
import models.Couleur;
import models.Hand;
import models.Paquet;
import models.Valeur;

public class Main {
    public static void main(String[] args) {
     
        // Carte carte1 = new Carte(Couleur.PIQUE, Valeur.AS);
        // Carte carte2 = new Carte(Couleur.COEUR, Valeur.ROI);
        // Carte carte3 = new Carte(Couleur.CARREAU, Valeur.SEPT);
        
        // System.out.println(carte1);
        // System.out.println(carte2);
        // System.out.println(carte3);
        
        // System.out.println("\nValeurs numériques :");
        // System.out.println(carte1 + " vaut " + carte1.getValue());
        // System.out.println(carte2 + " vaut " + carte2.getValue());
        // System.out.println(carte3 + " vaut " + carte3.getValue());

        // Paquet paquet = new Paquet();
        // System.out.println("Cartes dans le paquet : " + paquet.getNombreCartesRestantes());

        // paquet.melanger();
        // System.out.println("\nDistribution de 53 cartes :");
        
        // for (int i = 1; i <= 53; i++) {
        //     Carte carte = paquet.distribuerCarte();
        //     System.out.println("Carte " + i + " : " + carte + " (valeur: " + carte.getValue() + ")");
        // }
        
        // System.out.println("\nCartes restantes : " + paquet.getNombreCartesRestantes());
        
        Hand main = new Hand();
        
        // Test 1 : main normale
        main.ajouterCarte(new Carte(Couleur.PIQUE, Valeur.AS));
        main.ajouterCarte(new Carte(Couleur.COEUR, Valeur.NEUF));
        System.out.println(main);
        System.out.println("Score : " + main.getScore());  // Doit afficher 20
        
        System.out.println("\n---");
        
        // Test 2 : main avec As qui doit s'adapter
        main.ajouterCarte(new Carte(Couleur.CARREAU, Valeur.CINQ));
        System.out.println(main);
        System.out.println("Score : " + main.getScore());  // Doit afficher 15 (As vaut 1)
        
        System.out.println("\n---");
        
        // Test 3 : nouvelle main
        main.vider();
        main.ajouterCarte(new Carte(Couleur.TREFLE, Valeur.ROI));
        main.ajouterCarte(new Carte(Couleur.COEUR, Valeur.DIX));
        System.out.println(main);
        System.out.println("Score : " + main.getScore());  // Doit afficher 20

    }
}
