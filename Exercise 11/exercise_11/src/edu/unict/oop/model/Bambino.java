// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Bambino extends Visitatore {

    // COSTRUTTORI
    public Bambino(String nome, int eta, String biglietto, int identificatore, double prezzo) throws EccezioneOperazioneIrrealizzabile {
        super(nome, eta, biglietto, identificatore, prezzo);
    }

    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        
        if(eta > 10){
            throw new EccezioneOperazioneIrrealizzabile("Età MINIMA per Bambino NON RISPETTATA!");
        } else{ 
            super.setEta(eta);
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "Bambino{" + "nome=" + super.getNome() + ", eta=" + super.getEta() 
                    + ", identificatore=" + super.getIdentificatore() + ", prezzo=" + super.getPrezzo() + '}';
    }  
 
    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.50;
        return detrazione;
    }   
    
}
