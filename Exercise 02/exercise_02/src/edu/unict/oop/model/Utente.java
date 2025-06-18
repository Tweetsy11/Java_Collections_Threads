// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.VariazioneCostoAbbonamento;

public abstract class Utente implements VariazioneCostoAbbonamento {
    
    // ATTRIBUTI
    private final String nome;
    private int eta;
    private final String email;
    private final int identificativoUnivico;
    
    // COSTRUTTORI
    public Utente(String nome, int eta, String email, int identificativoUnivico) throws EccezioneOperazioneIrrealizzabile {
        this.nome = nome;
        setEta(eta);
        this.email = email;
        
        if(identificativoUnivico == 0){
            throw new EccezioneOperazioneIrrealizzabile("Identificativo dell'Utente NON può essere NULLO");
        } else if(identificativoUnivico < 0){
            throw new EccezioneOperazioneIrrealizzabile("Identificativo dell'Utente NON può essere NEGATIVO");
        } else{
            this.identificativoUnivico = identificativoUnivico;
        }
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public String getEmail() {
        return email;
    }

    public int getIdentificativoUnivico() {
        return identificativoUnivico;
    }
    
    // SETTER
    public void setEta(int eta) throws EccezioneOperazioneIrrealizzabile {
        if(eta == 0){
            throw new EccezioneOperazioneIrrealizzabile("Età dell'Utente NON può essere NULLA");
        } else if(eta < 0){
            throw new EccezioneOperazioneIrrealizzabile("Età dell'Utente NON può essere NEGATIVA");
        } else{
            this.eta = eta;            
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", eta=" + eta 
                    + ", email=" + email + ", identificativoUnivico=" + identificativoUnivico + '}';
    }
    
}
