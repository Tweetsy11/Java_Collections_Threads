// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Bambino extends Utente  {

    // COSTRUTTORI
    public Bambino(String nome, String cognome, int eta, String mail) throws EccezioneOperazioneIrrealizzabile {
        super(nome, cognome, eta, mail);
    }

    // SETTER
    @Override
    public void setEta(int eta)  throws EccezioneOperazioneIrrealizzabile {
        
        if(eta < 1){
            throw new EccezioneOperazioneIrrealizzabile("Età MINIMA per un Bambino NON RISPETTATA!");            
        }
        
        if(eta > 10){
            throw new EccezioneOperazioneIrrealizzabile("Età MASSIMA per un Bambino NON RISPETTATA!");
        }
        
        super.setEta(eta);
    }
    
    // toString
    @Override
    public String toString() {
        return "Bambino{" + "nome=" + super.getNome() + ", cognome=" + super.getCognome() 
                    + ", eta=" + super.getEta() + ", mail=" + super.getMail() + ", prezzo=" + super.getPrezzo()+ '}';
    }      

    @Override
    public double CalcolatorePrezzo() {
        double detrazione;
        if(super.getEta() < 5){
            detrazione = 0;
            return detrazione;
        }else if(super.getEta() > 5 && super.getEta() < 10){
            detrazione = 0.50;
            return detrazione;            
        }else{
            double nessunCambiamento = 1;
            return nessunCambiamento;
        }
    }  
}
