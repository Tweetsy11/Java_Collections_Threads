// PACKAGE
package edu.unict.oop.model;

// IMPORT
import java.time.LocalDate;

public abstract class Personaggio {
    
    // ATTRIBUTI
    private final String nome;
    private final LocalDate dataDiNascita;
    private final String codiceFiscale;
    
    // COSTRUTTORI
    public Personaggio(String nome, LocalDate dataDiNascita, String codiceFiscale) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    // toString
    @Override
    public String toString() {
        return "Personaggio{" + "nome=" + nome + ", dataDiNascita=" + dataDiNascita 
                    + ", codiceFiscale=" + codiceFiscale + '}';
    }    
    
}
