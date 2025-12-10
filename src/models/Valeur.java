package models;

public enum Valeur {
    DEUX(2, "Deux"),
    TROIS(3, "Trois"),
    QUATRE(4, "Quatre"),
    CINQ(5, "Cinq"),
    SIX(6, "Six"),
    SEPT(7, "Sept"),
    HUIT(8, "Huit"),
    NEUF(9, "Neuf"),
    DIX(10, "Dix"),
    VALET(10, "Valet"),
    DAME(10, "Dame"),
    ROI(10, "Roi"),
    AS(11, "As");

    private int valeurNumerique;
    private String nom;

    Valeur(int valeurNumerique, String nom) {
        this.valeurNumerique = valeurNumerique;
        this.nom = nom;
    }

    public int getValeurNumerique() {
        return valeurNumerique;
    }

    @Override
    public String toString() {
        return nom;
    }
}