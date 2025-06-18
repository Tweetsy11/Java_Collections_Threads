// PACKAGE
package edu.unict.oop.model;

// IMPORT
import java.time.LocalDate;

public class Cliente {
    
    // ATTRIBUTI
    private final String nome;
    private final LocalDate dataDiNascita;
    private final String email;
    
    // COSTRUTTORE
    public Cliente(String nome, LocalDate dataDiNascita, String email) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getEmail() {
        return email;
    }
    
    // toString
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", dataDiNascita=" + dataDiNascita + ", email=" + email + '}';
    }  
    
}
