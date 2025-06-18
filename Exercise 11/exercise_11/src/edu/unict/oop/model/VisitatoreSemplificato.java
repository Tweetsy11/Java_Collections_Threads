// PACKAGE
package edu.unict.oop.model;

public class VisitatoreSemplificato {
    
    // ATTRIBUTI
    private final String nome;
    private int numeroIdentificativo;
    
    // COSTRUTTORI
    public VisitatoreSemplificato(String nome, int numeroIdentificativo) {
        this.nome = nome;
        this.numeroIdentificativo = numeroIdentificativo;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public int getNumeroIdentificativo() {
        return numeroIdentificativo;
    }
    
    // SETTER
    public void setNumeroIdentificativo(int numeroIdentificativo) {
        this.numeroIdentificativo = numeroIdentificativo;
    }
     
    // toString
    @Override
    public String toString() {
        return "VisitatoreSemplificato{" + "nome=" + nome + ", numeroIdentificativo=" + numeroIdentificativo + '}';
    }
   
}
