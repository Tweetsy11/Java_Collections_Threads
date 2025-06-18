// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.List;

// Questa classe agisce da Monitor, tutte le Sincronizzazioni sono gestite qui.

public class Archivio {
    
    // COSTANTI
    static private final int MAX = 1000;
    
    // ATTRIBUTI
    private List<Acquisto> archivio;
    private int readCount;
    
    // COSTRUTTORI
    public Archivio() {
        archivio = new ArrayList<Acquisto>(MAX);
        readCount = 0;
    }
    
    // GETTER
    public List<Acquisto> getArchivio() {
        return archivio;
    }
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + '}';
    }
    
    // Metodo Sincronizzato per Aggiungere un Albero all'Archivio (se non gia presente)
    public synchronized void addAlbero(Acquisto acquisto) throws EccezioneOperazioneIrrealizzabile {

        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(archivio.size() == MAX || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
   
        if(archivio.contains(acquisto)) {
            System.out.println("L'Albero " + acquisto.getAlbero().getNumeroIdentificativo() + " è già presente nell'Archivio");
            throw new EccezioneOperazioneIrrealizzabile("Albero già Presente in Archivio!");
        }
        archivio.add(acquisto);
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
    }
    
    // Metodo Sincronizzato per Rimuovere un Albero dall'Archivio (se presente)
    public synchronized Acquisto removeAlbero(){

        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivio.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        Acquisto acquisto =  archivio.remove(0);
        
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa  
        
        return acquisto;
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
            System.out.println("Non sono presenti Alberi!");
        }else{
            archivio.forEach(System.out :: println);
        }
    }   
    
     // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioSync() {
        readLock();
        printArchivio();
        readUnlock();
    }    
 
}
