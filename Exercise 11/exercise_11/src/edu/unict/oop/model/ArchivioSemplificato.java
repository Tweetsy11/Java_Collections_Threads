// PACKAGE
package edu.unict.oop.model;

import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArchivioSemplificato {
    
    // COSTANTI
    static private final int MAX = 15;
    
    // ATTRIBUTI
    private final List<VisitatoreSemplificato> archivioSemplificato;
    private int readCount;
    
    // COSTRUTTORI
    public ArchivioSemplificato() {
        archivioSemplificato = new ArrayList<VisitatoreSemplificato>(MAX);
        readCount = 0;
    }
    
    // GETTER
    public List<VisitatoreSemplificato> getArchivioSemplificato() {
        return archivioSemplificato;
    }

    public int getReadCount() {
        return readCount;
    }
    
    // toString
    @Override
    public String toString() {
        return "ArchivioSemplificato{" + "archivioSemplificato=" + archivioSemplificato + ", readCount=" + readCount + '}';
    }
    
    // Metodo Sincronizzato per Aggiungere un Visitatore all'Archivio Semplificato (se non presente)
    public synchronized void addVisitatore(VisitatoreSemplificato visitatoreSemplificato) throws EccezioneOperazioneIrrealizzabile {
        
        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(archivioSemplificato.size() == MAX || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
   
        if(archivioSemplificato.contains(visitatoreSemplificato)) {
            System.out.println("Il Visitatore " + visitatoreSemplificato.getNome() + " è già presente nell'Archivio Semplificato");
            throw new EccezioneOperazioneIrrealizzabile("Visitatore già Presente in Archivio Semplificato!");
        }
        archivioSemplificato.add(visitatoreSemplificato);
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
    }
  
    // Metodo Sincronizzato per Rimuovere un Cliente dall'Archivio (se presente)
    public synchronized List<VisitatoreSemplificato> removeVisitatore(){
        List<VisitatoreSemplificato> listaVisitatoriRimossi = new ArrayList<VisitatoreSemplificato>();
        
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivioSemplificato.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("ciao");
                // ex.printStackTrace();
            }
        }
        
        Random random = new Random();
            
        // range Visitatori da Eliminare
        int minVisitatori = 1;
        int maxVisitatori = 5;

        // generatore casuale Visitatori da Eliminare
        int visitatori = random.nextInt(maxVisitatori + minVisitatori) + maxVisitatori;

        for(int numeroIdentificativo=0; numeroIdentificativo<visitatori; numeroIdentificativo++){            
                VisitatoreSemplificato visitatoreSemplificato =  archivioSemplificato.remove(numeroIdentificativo);
                listaVisitatoriRimossi.add(visitatoreSemplificato);           
        }
        
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa  
        
        return listaVisitatoriRimossi;
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
    
    // Metodo per Stampare l'Archivio (in ordine di cognome)
    public void printArchivioSemplificato(){
        if(archivioSemplificato.isEmpty()){
            System.out.println("Non sono presenti Visitatori!");
        }else{
            archivioSemplificato.forEach(System.out :: println);
        }
    }   
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioSemplificatoSync() {
        readLock();
        printArchivioSemplificato();
        readUnlock();
    }   
    
}
