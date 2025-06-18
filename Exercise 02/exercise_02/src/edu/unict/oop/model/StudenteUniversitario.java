// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class StudenteUniversitario extends Utente {

    // COSTRUTTORI
    public StudenteUniversitario(String nome, int eta, String email, int identificativoUnivico) throws EccezioneOperazioneIrrealizzabile {
        super(nome, eta, email, identificativoUnivico);
    }
    
    // toString
    @Override
    public String toString() {
        return "StudenteUniversitario{" + "nome=" + super.getNome() + ", eta=" + super.getEta()
                    + ", email=" + super.getEmail() + ", identificativoUnivico=" + super.getIdentificativoUnivico() + '}';
    }
    
    @Override
    public double CalcolatoreCosto() {
        double detrazione = 0.40;
        return detrazione;
    }
    
}
