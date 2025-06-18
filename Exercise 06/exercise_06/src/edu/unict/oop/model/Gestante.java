// PACKAGE
package edu.unict.oop.model;

public class Gestante extends ClienteAstratto {

    // COSTRUTTORI
    public Gestante(String cognome, int eta, String codiceFiscale) {
        super(cognome, eta, codiceFiscale);
    }
    
    // toString
    @Override
    public String toString() {
        return "Gestante{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta() + ", codiceFiscale=" + super.getCodiceFiscale() + '}';
    }   
    
    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.20;
        return detrazione;
    }    
    
}
