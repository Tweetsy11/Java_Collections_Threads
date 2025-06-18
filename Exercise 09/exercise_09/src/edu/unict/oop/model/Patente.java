// PACKAGE
package edu.unict.oop.model;

public class Patente {
    
    // ATTRIBUTI
    private final String tipologia;
    private final String codice;
    
    // COSTRUTTORI
    public Patente(String tipologia, String codice) {
        this.tipologia = tipologia;
        this.codice = codice;
    }
    
    // GETTER
    public String getTipologia() {
        return tipologia;
    }

    public String getCodice() {
        return codice;
    }
    
    // toString
    @Override
    public String toString() {
        return "Patente{" + "tipologia=" + tipologia + ", codice=" + codice + '}';
    }
    
}
