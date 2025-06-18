// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Adulto extends Visitatore {

    // COSTRUTTORI
    public Adulto(String nome, int eta, String biglietto, int identificatore, double prezzo) throws EccezioneOperazioneIrrealizzabile {
        super(nome, eta, biglietto, identificatore, prezzo);
    }

    // SETTER
    @Override
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta < 10){
            throw new EccezioneOperazioneIrrealizzabile("Età MINIMA per Adulto NON RISPETTATA!");
        } else if(eta > 72){
            throw new EccezioneOperazioneIrrealizzabile("Età MASSIMA per Adulto NON RISPETTATA!");
        } else{
            super.setEta(eta);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Adulto{" + "nome=" + super.getNome() + ", eta=" + super.getEta() 
                    + ", identificatore=" + super.getIdentificatore() + ", prezzo=" + super.getPrezzo() + '}';
    } 

    @Override
    public double CalcolatorePrezzo() {
        double nessunCambiamento = 1;
        return nessunCambiamento;
    }

}
