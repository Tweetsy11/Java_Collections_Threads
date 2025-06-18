// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiAbbonamento;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.Comparator;

public abstract class ClienteAstratto implements Comparable {
    
    // ATTRIBUTI
    private final String cognome;
    private int eta;
    private final String codiceFiscale;
    private final TipiAbbonamento abbonamento;
    
    // COSTRUTTORI
    public ClienteAstratto(String cognome, int eta, String codiceFiscale, TipiAbbonamento abbonamento) throws EccezioneOperazioneIrrealizzabile {
        this.cognome = cognome;
        setEta(eta);
        this.codiceFiscale = codiceFiscale;
        this.abbonamento = abbonamento;
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

    public TipiAbbonamento getAbbonamento() {
        return abbonamento;
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
        return "ClienteAstratto{" + "cognome=" + cognome + ", eta=" + eta 
                    + ", codiceFiscale=" + codiceFiscale + ", abbonamento=" + abbonamento + '}';
    }

    // Metodo Utilizzato per l'Ordinamento per Cognome
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
            ClienteAstratto other = (ClienteAstratto)oggetto;
            
            return this.cognome.compareTo(other.cognome);
            
        } else {
            return 1;
        }        
    }
    
    // Metodo Utilizzato per l'Ordinamento per Età
    public static final Comparator COMPARATORE_ETA = new Comparator() {
        @Override
        public int compare(Object oggetto1, Object oggetto2) {
            
            /*
               l'intero di ritorno può essere:
                -1 se il parametro viene prima di o1
                0 se il parametro è allo stesso livello
                1 se il parametro viene dopo o1
            */
            
            if (oggetto2 == null) {
                return 1;
            }
            
            if (oggetto1 == null) {
                return -1;
            }
        
            if (oggetto2 instanceof ClienteAstratto) {          
                    // solo qui posso fare il confronto diretto
                    return ((ClienteAstratto) oggetto1).getEta() - ((ClienteAstratto)oggetto2).getEta();      
            } else {
                    return 1;
            }
        }
        
    };         
 
}
