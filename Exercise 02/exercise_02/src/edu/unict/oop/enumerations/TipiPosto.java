// PACKAGE
package edu.unict.oop.enumerations;

public enum TipiPosto {  
    POLTRONISSIME(60, 3),
    GALLERIA(30, 5),
    NORMALI(15, 7);
    
    // ATTRIBUTI
    private final double costoPosto;
    private final int numTotPosti;
    private int numPostiLiberi;
    
    // COSTRUTTORI
    private TipiPosto(double costoPosto, int numTotPosti) {
        this.costoPosto = costoPosto;
        this.numTotPosti = numTotPosti;
        numPostiLiberi = numTotPosti;
    }
 
    // GETTER
    public double getCostoPosto() {
        return costoPosto;
    }

    public int getNumTotPosti() {
        return numTotPosti;
    }

    public int getNumPostiLiberi() {
        return numPostiLiberi;
    }
      
}
