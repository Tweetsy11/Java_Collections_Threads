// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.HashMap;
import java.util.Map;

public class Teatro {
    
    // ATTRIBUTI
    private final Map<String, Abbonamento> teatro;
    
    // COSTRUTTORI
    public Teatro() {
        this.teatro = new HashMap<String, Abbonamento>();
    }
    
    // GETTER
    public Map<String, Abbonamento> getTeatro() {
        return teatro;
    }
    
    // toString
    @Override
    public String toString() {
        return "Teatro{" + "teatro=" + teatro + '}';
    }
    
    // Metodo che Abbona un Utente al Teatro (se non già abbonato)
    public void addAbbonamento(Abbonamento abbonamento) throws EccezioneOperazioneIrrealizzabile {
        if(abbonamento == null){
            throw new EccezioneOperazioneIrrealizzabile("Abbonamento da Aggiungere NON SPECIFICATO!");
        }
        
        Abbonamento abbonamentoEsistente = teatro.get(abbonamento.getAbbonato().getEmail());
        if(abbonamentoEsistente == null){
            teatro.put(abbonamento.getAbbonato().getEmail(), abbonamento);
        } else{
            throw new EccezioneOperazioneIrrealizzabile("Email gia Usata!");
        }
    }
    
    // Metodo che Ricerca un Abbonamento in base all'Utente Abbonato
    public Abbonamento searchAbbonamento(Utente utente) throws EccezioneOperazioneIrrealizzabile {
        Abbonamento abbonamentoEsistente = teatro.get(utente.getEmail());
        if(abbonamentoEsistente == null){
            throw new EccezioneOperazioneIrrealizzabile("Abbonato NON Trovato!");
        }else{
            return abbonamentoEsistente;
        }  
    }
    
    // Metodo che Rimuove un Abbonamento dal Teatro (se presente)
    public Abbonamento removeAbbonamento(String email) throws EccezioneOperazioneIrrealizzabile {
        Abbonamento abbonamentoEsistente = teatro.get(email);
        if(abbonamentoEsistente == null){
            throw new EccezioneOperazioneIrrealizzabile("Email Inesistente!");
        }else if(teatro.isEmpty()){
            throw new EccezioneOperazioneIrrealizzabile("NON sono presenti Abbonamenti al Teatro!");
        }else{
            teatro.remove(email);
            return abbonamentoEsistente;
        }      
    }
    
    // Metodo che Mantiene il Guadagno del Teatro accumulato dal Costo degli Abbonamenti
    private double sommaGuadagno = 0;
    public double getGuadagno(){
        
        for(String email : teatro.keySet()){
            sommaGuadagno = sommaGuadagno + teatro.get(email).getCostoAbbonamento();
        }
        
        return sommaGuadagno;
    }
 
    // Metodo che Calcola l'Età Media degli Utenti Abbonati al Teatro
    public int getEtaMedia(){       
        int somma = 0;
        
        for(String email : teatro.keySet()){
            somma = somma + teatro.get(email).getAbbonato().getEta();
        }
        
        int dimensioneMappa = teatro.size();
        int mediaEta = somma / dimensioneMappa;
        return mediaEta;
    }
    
    // Metodo che Calcola il Numero di Studenti Universitari
    public int getNumStudentiUnviersitari(){
        int numStudentiUniversitari = 0;
        
        for(String email : teatro.keySet()){
            if(teatro.get(email).getAbbonato() instanceof StudenteUniversitario){
                numStudentiUniversitari = numStudentiUniversitari + teatro.get(email).getAbbonato().getEta();
            }
        }
        
        return numStudentiUniversitari;
    }        
    
    // Metodo che Stampa la Lista di tutti gli Abbonati con una Riduzione del Costo dell'Abbonamento
    public void printTeatro(){
        System.out.println("\nGli Abbonati al Teatro sono ");
        for (String email : teatro.keySet()) {
            System.out.println(teatro.get(email));
        }    
    }    
   
}
