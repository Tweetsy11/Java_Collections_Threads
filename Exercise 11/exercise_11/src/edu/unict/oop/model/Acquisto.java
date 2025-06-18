// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.interfaces.Sconto;

public class Acquisto {
    
    // ATTRIBUTI
    private final Visitatore visitatore;
    
    // COSTRUTTORE
    public Acquisto(Visitatore visitatore) {
        this.visitatore = visitatore;
    }
    
    // GETTER
    public Visitatore getVisitatore() {
        return visitatore;
    }
    
    // toString
    @Override
    public String toString() {
        return "Acquisto{" + "visitatore=" + visitatore + '}';
    }
    
    // Applicazione dello Sconto
    public double Sconto(){
        if(visitatore == null){
            return 0;
        }
        
        double prezzoFinale;
     
        if(visitatore instanceof Sconto){
            prezzoFinale = visitatore.getPrezzo() * ((Sconto)visitatore).CalcolatorePrezzo();
        } else {
            prezzoFinale = visitatore.getPrezzo();
        }
        
        return prezzoFinale;
    }
   
}
