// PACKAGE
package edu.unict.oop.enumerations;

public enum LivelliAbilita {
    BASE(0),
    PRINCIPIANTE(1),
    BREVETTO(2),
    ESPERTO(3),
    ISTRUTTORE(4);
    
    // ATTRIBUTI
    private final int livello;
    
    // COSTRUTTORE
    private LivelliAbilita(int livello) {
        this.livello = livello;
    }
    
    // GETTER
    public int getLivello() {
        return livello;
    }
    
}
