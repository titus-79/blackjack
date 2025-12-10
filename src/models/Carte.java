package models;

public class Carte {
    private Couleur couleur;
    private Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public int getValue() {
        return valeur.getValeurNumerique();
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}