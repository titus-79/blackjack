package models;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {

    private ArrayList<Carte> deck = new ArrayList<>();

    public Paquet() {
        for (Couleur couleur : Couleur.values()) {
            for (Valeur valeur : Valeur.values()) {
                Carte carte = new Carte(couleur, valeur);
                deck.add(carte);
            }
        }
    }

    public void melanger() {
        Collections.shuffle(deck);
    }

    public Carte distribuerCarte() {
        if (!deck.isEmpty()) {
            return deck.remove(deck.size() - 1);
        }
        System.out.println("Le paquet est vide !");
        return null;
    }

    public int getNombreCartesRestantes() {
        return deck.size();
    }
}
