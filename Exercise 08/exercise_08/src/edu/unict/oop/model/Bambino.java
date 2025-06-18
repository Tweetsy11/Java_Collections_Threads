// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiAbbonamento;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Bambino extends ClienteAstratto {

    // COSTRUTTORI
    public Bambino(String cognome, int eta, String codiceFiscale, TipiAbbonamento abbonamento) throws EccezioneOperazioneIrrealizzabile {
        super(cognome, eta, codiceFiscale, abbonamento);
    }   

    // SETTER
    @Override    
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta < 2){
            throw new EccezioneOperazioneIrrealizzabile("Età Minima per Bambino NON Rispettata!");
        } else if(eta > 7){
            throw new EccezioneOperazioneIrrealizzabile("Età Massima per Bambino NON Rispettata!");
        } else{
            super.getEta();
        }
    }   
    
    // toString
    @Override
    public String toString() {
        return "Bambino{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + ", abbonamento=" + super.getAbbonamento() + '}';
    }  
    
}
