// PACKAGE
package edu.unict.oop.enumerations;

public enum TipiCorso {
    CORSO_BASE(200),
    CORSO_PERFEZIONAMENTO(300),
    CORSO_GESTANTI(300),
    PALESTRA_GIOCHI(0);
    
    // ATTRIBUTI
    private double prezzo;
    
    // COSTRUTTORI
    private TipiCorso(double prezzo) {
        this.prezzo = prezzo;
    }
    
    // GETTER
    public double getPrezzo() {
        return prezzo;
    }  
    
    // SETTER
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
}
