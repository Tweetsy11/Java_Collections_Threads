// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.interfaces.Sconto;

public class Iscrizione {
    
    // ATTRIBUTI
    private final ClienteAstratto cliente;
    private Corso corso;
    
    // COSTRUTTORI
    public Iscrizione(ClienteAstratto cliente, Corso corso) {
        this.cliente = cliente;
        this.corso = corso;
    }
    
    // GETTER
    public ClienteAstratto getCliente() {
        return cliente;
    }

    public Corso getCorso() {
        return corso;
    }
    
    // SETTER
    public void setCorso(Corso corso) {
        this.corso = corso;
    }
    
    // toString
    @Override
    public String toString() {
        return "Iscrizione{" + "cliente=" + cliente + ", corso=" + corso + '}';
    }
    
    // Applicazione dello Sconto
    public double Sconto(){
        if(cliente == null || corso == null){
            return 0;
        }
        
        double prezzoFinale;
        
        if(cliente instanceof Sconto){
            prezzoFinale = corso.getCorso().getPrezzo() * ((Sconto)cliente).CalcolatorePrezzo();
        }else{
            prezzoFinale = corso.getCorso().getPrezzo();
        }
        
        return prezzoFinale;
    }
     
}
