// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.Sconto;

public abstract class Visitatore implements Sconto {
    
    // ATTRIBUTI
    private final String nome;
    private int eta;
    private final String biglietto;
    private final int identificatore;
    private double prezzo;
    
    // COSTRUTTORI
    public Visitatore(String nome, int eta, String biglietto, int identificatore, double prezzo) throws EccezioneOperazioneIrrealizzabile {
        this.nome = nome;
        setEta(eta);
        this.biglietto = biglietto;
        this.identificatore = identificatore;
        setPrezzo(prezzo);
    }
   
    // GETTER
    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public String getBiglietto() {
        return biglietto;
    }
    
    public int getIdentificatore() {
        return identificatore;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    // SETTER
    public void setPrezzo(double prezzo) throws EccezioneOperazioneIrrealizzabile {
        if(prezzo == 0){
            throw new EccezioneOperazioneIrrealizzabile("Prezzo NULLO non Ammesso!");
        }else if(prezzo < 0){
            throw new EccezioneOperazioneIrrealizzabile("Prezzo NULLO non Ammesso!");
        }else{
            this.prezzo = prezzo;            
        }
    }

    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta == 0){
            throw new EccezioneOperazioneIrrealizzabile("Età NULLA non Ammessa!");
        }else if(eta < 0){
            throw new EccezioneOperazioneIrrealizzabile("Età NULLA non Amessa!");
        }else{
            this.eta = eta;            
        }
    }

    // toString
    @Override
    public String toString() {
        return "Visitatore{" + "nome=" + nome + ", eta=" + eta + ", biglietto=" + biglietto 
                    + ", identificatore=" + identificatore + ", prezzo=" + prezzo + '}';
    }

    
}
