// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.List;

// Questa classe agisce da Monitor, tutte le Sincronizzazioni sono gestite qui.

public class Archivio {
    
    // ATTRIBUTI
    private final List<Acquisto> archivio;
    private int readCount;
    
    // COSTRUTTORI
    public Archivio() {
        archivio = new ArrayList<Acquisto>();
        readCount = 0;
    }
    
    // GETTER
    public List<Acquisto> getArchivio() {
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
    
    // Metodo Sincronizzato per Aggiungere un Acquisto all'Archivio (se non gia presente)
    public synchronized void addUtente(Acquisto acquisto) throws EccezioneOperazioneIrrealizzabile {
        
       // Attesa solo se c'è almeno un lettore
        while(readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
   
        if(archivio.contains(acquisto)) {
            System.out.println("L'Utente " + acquisto.getUtente().getNome() + acquisto.getUtente().getCognome() + " è già presente nell'Archivio");
            throw new EccezioneOperazioneIrrealizzabile("Utente già Presente in Archivio!");
        }
        archivio.add(acquisto);
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
    }
   
    // Metodo Sincronizzato per Rimuovere tutti gli Acquisti all'Archivio (se presenti)
    public synchronized void removeAllUtente(){

        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivio.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        archivio.removeAll(archivio);
        
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa  
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
            System.out.println("Non sono presenti Acquisti!");
        }else{
            archivio.forEach(System.out :: println);
        }
    }   
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArhivioSync() {
        readLock();
        printArchivio();
        readUnlock();
    }     
 
}
