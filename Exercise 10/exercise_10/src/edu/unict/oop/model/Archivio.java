// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.HashMap;
import java.util.Map;

public class Archivio {
    
    // ATTRIBUTI
    private final Map<String, Iscrizione> archivio;
    private int readCount;
    
    // COSTRUTTORI
    public Archivio() {
        this.archivio = new HashMap<>();
        readCount = 0;
    }
    
    // GETTER
    public Map<String, Iscrizione> getArchivio() {
        return archivio;
    }

    public int getReadCount() {
        return readCount;
    }  
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + ", readCount=" + readCount + '}';
    }
    
    // Metodo Sincronizzato che Aggiunge uno Studente ad un Corso (se non già presente)
    public synchronized void addCliente(String nomeStudente, Iscrizione iscrizione) throws EccezioneOperazioneIrrealizzabile {

        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(iscrizione.getCorso().getCapacitàMassima() <= 10 || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        Iscrizione iscrizioneEsistente = archivio.get(nomeStudente);
        if(iscrizioneEsistente == null){
            archivio.put(nomeStudente, new Iscrizione(nomeStudente, iscrizione.getCorso()));
        } else { 
            throw new EccezioneOperazioneIrrealizzabile("Codice Fiscale già Usato!");
        }     
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa

    }
    
    // Metodo Sincronizzato che Rimuove uno Studente da un Corso (se presente)
    public synchronized Iscrizione removeCliente(){
  
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivio.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        String codiceFiscale = archivio.keySet().iterator().next();
        Iscrizione iscrizione = archivio.remove(codiceFiscale);
        
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa 
        
        return iscrizione;
        
    }
    
    // Metodo Sincronizzato di Instaurazione Lock in Lettura    
    public synchronized void readLock() {
        readCount++;
    }

    // Metodo Sincronizzato di Rilascio Lock in Lettura    
    public synchronized void readUnlock() {
        readCount--;
        notifyAll(); // ATTENZIONE: la notifica è importante per risvegliare i thread in attesa
    }       
    
    // Metodo per Stampare l'Archivio 
    public void printArchivio(){
        if(archivio.isEmpty()){
            System.out.println("Non sono presenti Studenti!");
        } else{
            System.out.println("L'Archivio dei Visitatori del Museo è: ");
            for (String nomeStudente : archivio.keySet()) {
                System.out.println(archivio.get(nomeStudente));
            }
        }    
    }  
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioSync() {
        readLock();
        printArchivio();
        readUnlock();
    } 
    
}
