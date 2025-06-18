// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Anziano extends Utente {

    // COSTRUTTORI
    public Anziano(String nome, int eta, String email, int identificativoUnivico) throws EccezioneOperazioneIrrealizzabile {
        super(nome, eta, email, identificativoUnivico);
    }
    
    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta <= 75){
            throw new EccezioneOperazioneIrrealizzabile("Eta MINIMA per Anziano NON RISPETTATA!");
        } else{
            super.setEta(eta); 
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "Anziano{" + "nome=" + super.getNome() + ", eta=" + super.getEta()
                    + ", email=" + super.getEmail() + ", identificativoUnivico=" + super.getIdentificativoUnivico() + '}';
    } 
    
    @Override
    public double CalcolatoreCosto() {
        double detrazione = 0.30;
        return detrazione;
    }
        
}
