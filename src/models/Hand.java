package models;

import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Carte> hand = new ArrayList<>();

    public Hand() {
    }
    
    public void ajouterCarte(Carte carte) {
        hand.add(carte);
    }
    
    public int getScore() {
        int score = 0;
        int nbAs = 0;

        for (Carte carte : hand) {
            score += carte.getValue();
            if (carte.getValeur() == Valeur.AS) {
                nbAs++;
            }
        }

        while (score > 21 && nbAs > 0) {
            score -= 10;
            nbAs--;
        }
        return score;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< hand.size(); i++) {
           sb.append(hand.get(i));
           if (i < hand.size() - 1) {
            sb.append(", ");
           }
        }
        return sb.toString();
    }
    
    public void vider() {
        hand.clear();
    }

    public int getNombreCartes() {
       return hand.size();
    }

    public Carte getCarte(int index) {
        return hand.get(index);
    }

    public boolean estBlackjackNaturel() {
        return getNombreCartes() == 2 && getScore() == 21;
    }
}
