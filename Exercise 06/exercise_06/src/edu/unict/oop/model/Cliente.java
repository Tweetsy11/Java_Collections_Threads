// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Cliente extends ClienteAstratto {

    // COSTRUTTORI
    public Cliente(String cognome, int eta, String codiceFiscale) {
        super(cognome, eta, codiceFiscale);
    }
    
    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        
        if(eta > 2){
            throw new EccezioneOperazioneIrrealizzabile("Età NON Valida per un Cliente NON Pulcino!"); 
        }
        
        if(eta < 7){
            throw new EccezioneOperazioneIrrealizzabile("Età NON Valida per un Cliente NON Pulcino!");
        }
        
        super.setEta(eta); 
    }    
  
    // toString
    @Override
    public String toString() {
        return "Cliente{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta() + ", codiceFiscale=" + super.getCodiceFiscale() + '}';
    }

    @Override
    public double CalcolatorePrezzo() {
        double nessunCambiamento = 1;
        return nessunCambiamento;
    }
 
}
