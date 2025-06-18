// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiCorso;

public class Corso {
   
    // ATTRIBUTI
    private TipiCorso corso;
    
    // COSTRUTTORI
    public Corso(TipiCorso corso) {
        this.corso = corso;
    }
    
    // GETTER
    public TipiCorso getCorso() {
        return corso;
    }
    
    // SETTER
    public void setCorso(TipiCorso corso) {
        this.corso = corso;
    }
    
    // toString
    @Override
    public String toString() {
        return "Corso{" + "corso=" + corso + ", prezzo=" + corso.getPrezzo() + '}';
    }
 
}
