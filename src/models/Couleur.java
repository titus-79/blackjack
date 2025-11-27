package models;

public enum Couleur {
      PIQUE("Pique"),
      COEUR("Coeur"),
      CARREAU("Carreau"),
      TREFLE("Trefle");

      private String nom;

      Couleur(String nom) {
         this.nom = nom;
      }

      @Override

      public String toString() {
         return nom;
      }
}

