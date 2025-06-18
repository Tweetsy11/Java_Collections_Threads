// PACKAGE
package edu.unict.oop.model;

import edu.unic.oop.enumerations.TipiCorso;

public class Iscrizione {
    
    // ATTRIBUTI
    private final String nomeStudente;
    private final TipiCorso corso;
    
    // COSTRUTTORI
    public Iscrizione(String nomeStudente, TipiCorso corso) {
        this.nomeStudente = nomeStudente;
        this.corso = corso;
    }
    
    // GETTER
    public String getNomeStudente() {
        return nomeStudente;
    }

    public TipiCorso getCorso() {
        return corso;
    }
    
    // toString
    @Override
    public String toString() {
        return "Iscrizione{" + "nomeStudente=" + nomeStudente + ", corso=" + corso + '}';
    }  
    
}
