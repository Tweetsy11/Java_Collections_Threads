// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.interfaces.Sconto;

public class Acquisto {
   
    // ATTRIBUTI
    private final Utente utente;
    
    // COSTRUTTORI
    public Acquisto(Utente utente) {
        this.utente = utente;
    }
    
    // GETTER
    public Utente getUtente() {
        return utente;
    }
   
    // toString
    @Override
    public String toString() {
        return "Acquisto{" + "utente=" + utente + '}';
    }
    
    // Applicazione dello Sconto
    public double Sconto(){
        if(utente == null){
            return 0;
        }
        
        double prezzoFinale;
        
        if(utente instanceof Sconto){
            prezzoFinale = utente.getPrezzo() * ((Sconto)utente).CalcolatorePrezzo();
        }else{
            prezzoFinale = utente.getPrezzo();
        }
        
        return prezzoFinale;
    }
    
}
