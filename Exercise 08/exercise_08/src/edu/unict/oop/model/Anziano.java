// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiAbbonamento;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Anziano extends ClienteAstratto {

    // COSTRUTTORI
    public Anziano(String cognome, int eta, String codiceFiscale, TipiAbbonamento abbonamento) throws EccezioneOperazioneIrrealizzabile {
        super(cognome, eta, codiceFiscale, abbonamento);
    }    

    // SETTER
    @Override    
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta <= 75){
            throw new EccezioneOperazioneIrrealizzabile("Età Minima per Anziano NON Rispettata!");
        } else { 
            super.getEta();
        }
    }    

    // toString
    @Override
    public String toString() {
        return "Anziano{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + ", abbonamento=" + super.getAbbonamento() + '}';
    }   
    
}
