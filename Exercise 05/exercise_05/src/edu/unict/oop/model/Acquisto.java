// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.interfaces.VariazionePrezzo;

public class Acquisto {
    
    // ATTRIBUTI
    private final Albero albero;
    
    // COSTRUTTORI
    public Acquisto(Albero albero) {
        this.albero = albero;
    }
    
    // GETTER
    public Albero getAlbero() {
        return albero;
    }
    
    // toString
    @Override
    public String toString() {
        return "Acquisto{" + "albero=" + albero + '}';
    }
    
    // Applicazione della Variazione del Prezzo
    public double VariazionePrezzo(){
        
        if(albero == null){
            return 0;
        }
        
        double prezzoFinale; 
        
        if(albero instanceof VariazionePrezzo){
            prezzoFinale = albero.getPrezzo() * ((VariazionePrezzo)albero).CalcolatorePrezzo();
        }else{ 
            prezzoFinale = albero.getPrezzo();
        }
        
        return prezzoFinale;
    }
       
}
