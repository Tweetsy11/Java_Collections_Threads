// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Anziano extends Utente {

    // COSTRUTTORI
    public Anziano(String nome, String cognome, int eta, String mail) throws EccezioneOperazioneIrrealizzabile {
        super(nome, cognome, eta, mail);
    }

    // SETTER
    @Override
    public void setEta(int eta)  throws EccezioneOperazioneIrrealizzabile {
        
        if(eta < 66){
            throw new EccezioneOperazioneIrrealizzabile("Età MINIMA per un Anziano NON RISPETTATA!");
        }
        
        super.setEta(eta);
    }
    
    // toString
    @Override
    public String toString() {
        return "Anziano{" + "nome=" + super.getNome() + ", cognome=" + super.getCognome() 
                    + ", eta=" + super.getEta() + ", mail=" + super.getMail() + ", prezzo=" + super.getPrezzo()+ '}';
    }    

    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.30;
        return detrazione;
    }
       
}
