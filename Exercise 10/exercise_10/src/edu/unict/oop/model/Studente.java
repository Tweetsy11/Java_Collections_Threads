// PACKAGE
package edu.unict.oop.model;

// IMPORT
import java.time.LocalDate;

public class Studente extends Personaggio {

    // COSTRUTTORI
    public Studente(String nome, LocalDate dataDiNascita, String codiceFiscale) {
        super(nome, dataDiNascita, codiceFiscale);
    }
  
    // toString
    @Override
    public String toString() {
        return "Studente{" + "nome=" + super.getNome() + ", dataDiNascita=" + super.getDataDiNascita()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + '}';
    }
    
}
