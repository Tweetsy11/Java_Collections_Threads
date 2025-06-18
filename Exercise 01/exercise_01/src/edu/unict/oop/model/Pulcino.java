// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Pulcino extends ClienteAstratto implements Comparable<Pulcino> {

    // COSTRUTTORI
    public Pulcino(String cognome, int eta, String codiceFiscale) {
        super(cognome, eta, codiceFiscale);
    }
    
    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        
        if(eta < 2){
            throw new EccezioneOperazioneIrrealizzabile("Età Minima per un Pulcino NON Rispettata!"); 
        }
        
        if(eta > 7){
            throw new EccezioneOperazioneIrrealizzabile("Età Massima per un Pulcino NON Rispettata!");
        }
        
        super.setEta(eta); 
    }

     // toString
    @Override
    public String toString() {
        return "Pulcino{" + "cognome=" + super.getCognome() + ", eta=" + super.getEta() 
                    + ", codiceFiscale=" + super.getCodiceFiscale() + '}';
    }  

    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.30;
        return detrazione;
    }

    @Override
    public int compareTo(Pulcino pulcino) {
        
        if (pulcino == null) {
            return -1;
        }
        
        // -1 quando l'oggetto corrente è inferiore a quello passato come parametro    
        // zero quando gli elementi sono uguali ai fini dell'ordinamento     
        // 1 quando l'oggetto corrente è superiore a quello passato come parametro
        
        return getEta() - pulcino.getEta();
        
    }
    

}
