// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.Sconto;

public abstract class ClienteAstratto implements Sconto {
    
    // ATTRIBUTI
    private final String cognome;
    private int eta;
    private final String codiceFiscale;
    
    // COSTRUTTORI
    public ClienteAstratto(String cognome, int eta, String codiceFiscale) {
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
    }
    
    // GETTER
    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    // SETTER
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {      
        if(eta == 0){
            throw new EccezioneOperazioneIrrealizzabile("Età NULLA non Ammessa!");
        } else if(eta < 0) { 
            throw new EccezioneOperazioneIrrealizzabile("Età NEGATIVA non Ammessa!");         
        }else{
            this.eta = eta; 
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "Cliente{" + "cognome=" + cognome + ", eta=" + eta + ", codiceFiscale=" + codiceFiscale + '}';
    }
 
}