// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Adulto extends Utente {

    // COSTRUTTORI
    public Adulto(String nome, String cognome, int eta, String mail) throws EccezioneOperazioneIrrealizzabile {
        super(nome, cognome, eta, mail);
    }     

    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        
        if(eta < 11){
            throw new EccezioneOperazioneIrrealizzabile("Età MINIMA per un Adulto NON RISPETTATA!");            
        }
        
        if(eta > 65){
            throw new EccezioneOperazioneIrrealizzabile("Età MASSIMA per Età Adulto NON RISPETTATA!");
        }
        
        super.setEta(eta);
    }

    // toString
    @Override
    public String toString() {
        return "Adulto{" + "nome=" + super.getNome() + ", cognome=" + super.getCognome() 
                    + ", eta=" + super.getEta() + ", mail=" + super.getMail() + ", prezzo=" + super.getPrezzo()+ '}';
    }   
    
    @Override
    public double CalcolatorePrezzo() {
        double nessunCambiamento = 1;
        return nessunCambiamento;        
    }
}
