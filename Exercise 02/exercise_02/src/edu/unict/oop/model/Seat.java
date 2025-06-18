// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiPosto;

public class Seat {

    // ATTRIBUTI
    private final String informazioniUtente;
    private final TipiPosto posto;

    // COSTRUTTORI
    public Seat(String informazioniUtente, TipiPosto posto) {
        this.informazioniUtente = informazioniUtente;
        this.posto = posto;
    }

    // GETTER
    public String getInformazioniUtente() {
        return informazioniUtente;
    }

    public TipiPosto getPosto() {
        return posto;
    }

    // toString
    @Override
    public String toString() {
        return "Seat{" + "informazioniUtente=" + informazioniUtente + ", posto=" + posto + '}';
    }
    
}
