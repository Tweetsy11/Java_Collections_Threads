// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiAbbonamento;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Cliente extends ClienteAstratto {

    // COSTRUTTORI
    public Cliente(String cognome, int eta, String codiceFiscale, TipiAbbonamento abbonamento) throws EccezioneOperazioneIrrealizzabile {
        super(cognome, eta, codiceFiscale, abbonamento);
    }    

    // SETTER
    @Override    
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta < 8){
            throw new EccezioneOperazioneIrrealizzabile("Età DISPONIBILE solo per un BAMBINO!");
        } else if(eta > 75){
            throw new EccezioneOperazioneIrrealizzabile("Età DISPONIBILE solo per un ANZIANO!");
        } else{
            super.getEta();
        }
    }    

    // toString
    @Override
    public String toString() {
        return "Cliente{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + ", abbonamento=" + super.getAbbonamento() + '}';
    } 
     
}
