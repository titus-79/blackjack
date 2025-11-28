package models;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
    
    private ArrayList<Carte> deck = new ArrayList<>();

    // constructeur qui génère les 52 cartes
    public Paquet () {
        // ArrayList<String> deck = new ArrayList<>();
        for (Couleur couleur: Couleur.values()) {
            for (Valeur valeur: Valeur.values()) {
                Carte carte = new Carte(couleur, valeur);
                deck.add(carte);
            }
        }
    }

    // méthode mélanger()
    public void melanger() {
        Collections.shuffle(deck);
    }
    
    // méthode distribuerCarte()
    public Carte distribuerCarte() {
        if (!deck.isEmpty()) {
            return deck.remove(deck.size() - 1); 
        }
        System.out.println("Le paquet est vide !");
        return null;
    }
    
    // méthode getNombreCartesRestantes()
    public int getNombreCartesRestantes() {
            return deck.size();
    }
}
