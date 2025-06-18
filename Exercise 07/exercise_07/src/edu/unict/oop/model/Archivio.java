// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Questa classe agisce da Monitor, tutte le Sincronizzazioni sono gestite qui.

public class Archivio {
    
    // COSTANTI
    static private final int MAX = 25;
    
    // ATTRIBUTI
    private final List<Cliente> archivio;
    private int readCount;
    
    // COSTRUTTORI
    public Archivio() {
        archivio = new ArrayList<Cliente>(MAX);
        readCount = 0;
    }
    
    // GETTER
    public List<Cliente> getArchivio() {
        return archivio;
    }

    public int getReandCount() {
        return readCount;
    }
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + ", reandCount=" + readCount + '}';
    }
    
    // Metodo Sincronizzato per Aggiungere un Cliente all'Archivio (se non presente)
    public synchronized void addCliente(Cliente cliente) throws EccezioneOperazioneIrrealizzabile {
        
        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(archivio.size() == MAX || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
   
        if(archivio.contains(cliente)) {
            System.out.println("Il Cliente " + cliente.getCognome() + " è già presente nell'Archivio");
            throw new EccezioneOperazioneIrrealizzabile("Cliente già Presente in Archivio!");
        }
        archivio.add(cliente);
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
    }
  
    // Metodo Sincronizzato per Rimuovere un Cliente dall'Archivio (se presente)
    public synchronized Cliente removeCliente(){

        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivio.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        Cliente cliente =  archivio.remove(0);
        
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa  
        
        return cliente;
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
    public void printArchivioOrdinatoPerCognome(){
        if(archivio.isEmpty()){
            System.out.println("Non sono presenti Clienti!");
        }else{
            List<Cliente> listaClienti = new ArrayList<Cliente>();
            Collections.sort(listaClienti);
            listaClienti.forEach(System.out :: println);
        }
    }   
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioOrdinatoPerCognomeSync() {
        readLock();
        printArchivioOrdinatoPerCognome();
        readUnlock();
    }   
    
    // Metodo per Stampare solo le Gestanti presenti nell'Archivio (in ordine di età)
    public void printArchivioGestantiOrdinatoPerEtà(){
        if(archivio.isEmpty()){
            System.out.println("Non sono presenti Clienti!");
        }else{
            List<Gestante> listaGestanti = new ArrayList<Gestante>();
            for (Cliente cliente : listaGestanti) {
                if (cliente instanceof Gestante) {
                    listaGestanti.add((Gestante) cliente);
                }
            }
            Collections.sort(listaGestanti, Gestante.COMPARATORE_ETA);
            listaGestanti.forEach(System.out :: println);
        }
    }   
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioGestantiOrdinatoPerEtàSync() {
        readLock();
        printArchivioGestantiOrdinatoPerEtà();
        readUnlock();
    }      

}
