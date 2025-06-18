// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.HashMap;
import java.util.Map;

// Questa classe agisce da Monitor, tutte le Sincronizzazioni sono gestite qui.

public class Buffer {

    // ATTRIBUTI
    private final Map<String, Seat> buffer;
    private int readCount;

    // COSTRUTTORI
    public Buffer() {
        this.buffer = new HashMap<String,Seat>();
        readCount = 0;
    }
    
    // GETTER
    public Map<String, Seat> getBuffer() {
        return buffer;
    }

    public int getReadCount() {
        return readCount;
    }
  
    // toString
    @Override
    public String toString() {
        return "Buffer{" + "buffer=" + buffer + ", readCount=" + readCount + '}';
    } 
    
    // Metodo Sincronizzato che Aggiunge un Utente al Buffer (se non già presente)
    public synchronized void addUtente(Seat seat) throws EccezioneOperazioneIrrealizzabile {
        
        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(seat.getPosto().getNumPostiLiberi() == 0 || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        if(buffer.containsKey(seat.getInformazioniUtente())){
            throw new EccezioneOperazioneIrrealizzabile("Utente già Inserito!");
        } else{       
            buffer.put(seat.getInformazioniUtente(), seat);
            notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
        }  
    }
    
    // Metodo Sincronizzato che Rimuove un Utente dal Buffer (se presente)
    public synchronized Seat removeUtente(){
  
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(buffer.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }       
        String informazioniUtente = buffer.keySet().iterator().next();
        Seat seat = buffer.remove(informazioniUtente);       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa     
        return seat;
    }
       
    // Metodo Sincronizzato di Instaurazione Lock in Lettura
    public synchronized void readLock() {
        readCount++;
    }
  
    // Metodo Sincronizzato di Rilascio Lock in Lettura 
    public synchronized void readUnlock() {
        if (--readCount == 0)
            notifyAll(); 
    }       

    // Metodo per Stampare il Buffer
    public void printBuffer(){
        if(buffer.isEmpty()){
            System.out.println("Non sono presenti Utenti!");
        } else{
            for (String informazioniUtente : buffer.keySet()) {
                System.out.println(buffer.get(informazioniUtente));
            } 
        }  
    }
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printBufferSync() {
        readLock();
        printBuffer();
        readUnlock();
        
    }
       
    // Metodo per Calcolare e Stampare l'Introito Attuale contenuto nel Buffer
    public void printIntroitoAttuale(){
        double introitoAttuale = 0;
        for (String informazioniUtente : buffer.keySet()) {
            introitoAttuale = introitoAttuale + buffer.get(informazioniUtente).getPosto().getCostoPosto();
        }   
        double introitoEffettivo = introitoAttuale * 0.80;
        System.out.println("L'Introito Attuale Effettivo contenuto nel Buffer è: " + introitoEffettivo);
    }    

    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printIntroitoAttualeSync() {
        readLock();
        printIntroitoAttuale();
        readUnlock();
        
    }  
  
}
