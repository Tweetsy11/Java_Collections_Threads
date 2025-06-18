// PACKAGE
package edu.unict.oop.enumerations;

public enum TipiFasciaPosto {  
    POLTRONISSIME(1.40, 3,3),
    GALLERIA(0.70, 5,5),
    NORMALI(1, 7,7);
    
    // ATTRIBUTI
    private final double fattoreMoltiplicativo;
    private final int numTotPosti;
    private int numPostiLiberi;
    
    // COSTRUTTORI
    private TipiFasciaPosto(double fattoreMoltiplicativo, int numTotPosti, int numPostiLiberi) {
        this.fattoreMoltiplicativo = fattoreMoltiplicativo;
        this.numTotPosti = numTotPosti;
        this.numPostiLiberi = numPostiLiberi;
    }
 
    // GETTER
    public double getFattoreMoltiplicativo() {
        return fattoreMoltiplicativo;
    }

    public int getNumTotPosti() {
        return numTotPosti;
    }

    public int getNumPostiLiberi() {
        return numPostiLiberi;
    }
     
}
