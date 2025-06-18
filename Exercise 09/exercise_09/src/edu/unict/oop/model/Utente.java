// PACKAGE
package edu.unict.oop.model;

public class Utente {
    
    // ATTRIBUTI
    private final String nome;
    private final int recapitoTelefonico;
    private final String email;
    private final String codiceFiscale;
    
    // COSTRUTTORI
    public Utente(String nome, int recapitoTelefonico, String email, String codiceFiscale) {
        this.nome = nome;
        this.recapitoTelefonico = recapitoTelefonico;
        this.email = email;
        this.codiceFiscale = codiceFiscale;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public int getRecapitoTelefonico() {
        return recapitoTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    // toString
    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", recapitoTelefonico=" + recapitoTelefonico 
                    + ", email=" + email + ", codiceFiscale=" + codiceFiscale + '}';
    }
    
}
