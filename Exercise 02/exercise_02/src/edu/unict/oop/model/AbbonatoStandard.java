// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class AbbonatoStandard extends Utente {

    // COSTRUTTORI
    public AbbonatoStandard(String nome, int eta, String email, int identificativoUnivico) throws EccezioneOperazioneIrrealizzabile {
        super(nome, eta, email, identificativoUnivico);
    }
    
    // toString
    @Override
    public String toString() {
        return "AbbonatoStandard{" + "nome=" + super.getNome() + ", eta=" + super.getEta()
                    + ", email=" + super.getEmail() + ", identificativoUnivico=" + super.getIdentificativoUnivico() + '}';
    }       

    @Override
    public double CalcolatoreCosto() {
        double detrazione = 1;
        return detrazione;
    }

}
