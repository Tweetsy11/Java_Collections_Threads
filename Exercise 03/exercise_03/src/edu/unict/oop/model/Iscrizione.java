// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.LivelliAbilita;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Iscrizione {
    
    // ATTRIBUTI
    private final Cliente cliente;
    private final int codiceUtente;
    private final LivelliAbilita livelloAbilita;
    
    // COSTRUTTORI
    public Iscrizione(Cliente cliente, int codiceUtente, LivelliAbilita livelloAbilita) throws EccezioneOperazioneIrrealizzabile {
        this.cliente = cliente;
        
        if(codiceUtente == 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Codice Utente NON può essere NULLO!");
        } else if(codiceUtente < 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Codice Utente NON può essere NEGATIVO!");
        }else{
            this.codiceUtente = codiceUtente;
        }
        
        this.livelloAbilita = livelloAbilita;
    }
    
    // GETTER
    public Cliente getCliente() {
        return cliente;
    }

    public int getCodiceUtente() {
        return codiceUtente;
    }

    public LivelliAbilita getLivelloAbilita() {
        return livelloAbilita;
    }
    
    // toString
    @Override
    public String toString() {
        return "Iscrizione{" + "cliente=" + cliente + ", codiceUtente=" + codiceUtente 
                    + ", livelloAbilita=" + livelloAbilita + '}';
    }
 
}
