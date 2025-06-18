// PACKAGE
package edu.unic.oop.enumerations;

public enum TipiCorso {
    MUSICA(10),
    PITTURA(10),
    POTENIZAMENTO_DIDATTICO(10);
    
    // ATTRIBUTI
    private final int capacitàMassima;
    
    // COSTRUTTORI
    private TipiCorso(int capacitàMassima) {
        this.capacitàMassima = capacitàMassima;
    }
    
    // GETTER
    public int getCapacitàMassima() {
        return capacitàMassima;
    }
    
}

