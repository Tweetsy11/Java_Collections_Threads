// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.Sconto;

public abstract class Utente implements Sconto {
    
    // ATTRIBUTI
    private final String nome;
    private final String cognome;
    private int eta;
    private final String mail;
    private double prezzo;
    
    // COSTRUTTORI
    public Utente(String nome, String cognome, int eta, String mail) throws EccezioneOperazioneIrrealizzabile {
        this.nome = nome;
        this.cognome = cognome;
        setEta(eta);
        this.mail = mail;
        prezzo = 100;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getMail() {
        return mail;
    }

    public double getPrezzo() {
        return prezzo;
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
    
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // toString
    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", mail=" + mail + ", prezzo=" + prezzo + '}';
    }
    
}
