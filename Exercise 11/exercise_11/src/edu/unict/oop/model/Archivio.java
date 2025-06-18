// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {
    
    // ATTRIBUTI
    private final Map<Integer, Acquisto> archivio;
    
    // COSTRUTTORI
    public Archivio() {
        this.archivio = new HashMap<>();
    }
    
    // GETTER
    public Map<Integer, Acquisto> getArchivio() {
        return archivio;
    } 
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + '}';
    }
    
    // Metodo per Aggiunge un Visitatore all'Archivio (se non presente)
    public void addVisitatore(Visitatore visitatore) throws EccezioneOperazioneIrrealizzabile {
        
        if(visitatore == null){
            throw new EccezioneOperazioneIrrealizzabile("Visitatore da Aggiungere NON SPECIFICATO!");
        }
        
        Acquisto acquistoEsistente = archivio.get(visitatore.getIdentificatore());
        if(acquistoEsistente == null){
            Acquisto acquisto = new Acquisto(visitatore);
            double prezzoFinale = acquisto.Sconto();
            acquisto.getVisitatore().setPrezzo(prezzoFinale);
            archivio.put(visitatore.getIdentificatore(), acquisto);
        } else { 
            throw new EccezioneOperazioneIrrealizzabile("Numero Identificativo già Usato!");
        } 
    }    
    
    // Metodo per Rimuovere un Visitatore dall'Archivio (se presente)
    public Visitatore removeVisitatore(int numeroIdentificativo) throws EccezioneOperazioneIrrealizzabile {       
        Acquisto acquistoEsistente = archivio.get(numeroIdentificativo);
        
        if (acquistoEsistente != null) {
            return archivio.remove(numeroIdentificativo).getVisitatore();
        } else {
            throw new EccezioneOperazioneIrrealizzabile("Numero Identificativo Inesistente!");
        }     
    }    
    
    // Metodo di Stampa dell'Archivio 
    public void printArchivio(){
        System.out.println("L'Archivio dei Visitatori del Museo è: ");
        for (int numeroIdentificativo : archivio.keySet()) {
            System.out.println(archivio.get(numeroIdentificativo));
        }    
    }  
      
    // Metodo che Ricerca un Visitatore in base al Codice Fiscale
    public Visitatore searchVisitatore(int numeroIdentificativo) throws EccezioneOperazioneIrrealizzabile {
        Acquisto acquistoEsistente = archivio.get(numeroIdentificativo);
        if (acquistoEsistente == null) {
            throw new EccezioneOperazioneIrrealizzabile("Visitatore NON Trovato!");
        }     
        return acquistoEsistente.getVisitatore();             
    }    
     
    // Metodo per Valutare il Numero di Visitatori attualmente contenuti in Archivio
    public int numVisitatori(){
        // DA IMPLEMENTARE
        return 0;
        
    }
        
    // Metodo per Valutare il Numero di Bambini attualmente contenuti in Archivio
    public int numBambini(){
        // DA IMPLEMENTARE
        return 0;
        
    }    
       
    // Metodo per Stampare il Numero di Bambini attualmente contenuti in Archivio   
    public List<Bambino> printBambini(){
        // DA IMPLEMENTARE
        return null;
        
    }    
}
