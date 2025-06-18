// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiSesso;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.Comparator;

public class Gestante extends Cliente {

    // COSTRUTTORI
    public Gestante(String cognome, int eta, TipiSesso sesso, String corso) throws EccezioneOperazioneIrrealizzabile {
        super(cognome, eta, sesso, corso);
    }

    // toString
    @Override
    public String toString() {
        return "Gestante{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta() 
                    + ", sesso=" + super.getSesso() + ", corso=" + super.getCorso() + '}';
    }   
    
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
        
            if (oggetto2 instanceof Gestante) {
                if (oggetto1 instanceof Gestante) {
                    
                    // solo qui posso fare il confronto diretto
                    return -(((Gestante) oggetto2).getEta() - ((Gestante) oggetto1).getEta());
                    
                } else {
                    return -1;
                }
                
            } else {
                return 1;
            }
        }
        
    };   
    
}
