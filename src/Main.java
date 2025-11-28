import models.Carte;
import models.Couleur;
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

        Paquet paquet = new Paquet();
        System.out.println("Cartes dans le paquet : " + paquet.getNombreCartesRestantes());

        paquet.melanger();
        System.out.println("\nDistribution de 53 cartes :");
        
        for (int i = 1; i <= 53; i++) {
            Carte carte = paquet.distribuerCarte();
            System.out.println("Carte " + i + " : " + carte + " (valeur: " + carte.getValue() + ")");
        }
        
        System.out.println("\nCartes restantes : " + paquet.getNombreCartesRestantes());
    }
}
