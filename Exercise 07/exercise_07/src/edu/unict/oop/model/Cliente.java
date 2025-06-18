// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiSesso;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Cliente implements Comparable {
    
    // ATTRIBUTI
    private final String cognome;
    private int eta;
    private final TipiSesso sesso;
    private final String corso;
    
    // COSTRUTTORI
    public Cliente(String cognome, int eta, TipiSesso sesso, String corso) throws EccezioneOperazioneIrrealizzabile {
        this.cognome = cognome;
        setEta(eta);
        this.sesso = sesso;
        this.corso = corso;
    }
    
    // GETTER
    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public TipiSesso getSesso() {
        return sesso;
    }

    public String getCorso() {
        return corso;
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
        return "Cliente{" + "cognome=" + cognome + ", eta=" + eta 
                    + ", sesso=" + sesso + ", corso=" + corso + '}';
    }

    @Override
    public int compareTo(Object oggetto) {
        
        /*
           l'intero di ritorno può essere:
             -1 se il parametro viene prima dell'oggetto corrente
             0 se il parametro è allo stesso livello
             1 se il parametro viene dopo l'oggetto corrente
        */
        
        if (oggetto == null) {
            return 1;
        }
        
        if (oggetto instanceof Cliente) {
            Cliente other = (Cliente)oggetto;
            
            return this.cognome.compareTo(other.cognome);
            
        } else {
            return 1;
        }        
    }
      
}
