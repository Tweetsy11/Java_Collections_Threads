// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Questa classe agisce da Monitor, tutte le Sincronizzazioni sono gestite qui.

public class Archivio {
    
    // COSTANTI
    private static final int MAX = 20;
    
    // ATTRIBUTI
    private final Map <String, ClienteAstratto> archivio;
    private int readCount;
    
    // COSTRUTTORI
    public Archivio() {
        this.archivio = new HashMap<String, ClienteAstratto>(MAX);
    }
    
    // GETTER
    public Map<String, ClienteAstratto> getArchivio() {
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
    
    // Metodo Sincronizzato che Aggiunge un Cliente all'Archivio (se non già presente)
    public synchronized void addCliente(String codiceFiscale, ClienteAstratto cliente) throws EccezioneOperazioneIrrealizzabile {

        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(archivio.size() == MAX || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        if(archivio.containsKey(codiceFiscale)){
            System.out.println("Il Cliente " + cliente.getCognome() + " è già presente nell'Archivio");
            throw new EccezioneOperazioneIrrealizzabile("Cliente già Presente in Archivio!");
        }else{
            archivio.put(codiceFiscale, cliente);
        }
       
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa

    }
    
    // Metodo Sincronizzato che Rimuove un Cliente dall'Archivio (se presente)
    public synchronized ClienteAstratto removeCliente(){
  
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(archivio.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        String codiceFiscale = archivio.keySet().iterator().next();
        ClienteAstratto cliente = archivio.remove(codiceFiscale);
        
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
        } else{
            List<ClienteAstratto> listaClienti = new ArrayList<>(archivio.values());
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
    
    // Metodo per Stampare l'Archivio (in ordine di cognome)
    public void printArchivioSoloBambiniAnzianiOrdinatoPerEta(){
        List<ClienteAstratto> listaAnzianiAndBambini = new ArrayList<ClienteAstratto>();
        if(archivio.isEmpty()){
            System.out.println("Non sono presenti Clienti!");
        } else{
            for (String codiceFiscale : archivio.keySet()) {  
                ClienteAstratto clienteAstratto = archivio.get(codiceFiscale);
                if (clienteAstratto instanceof Bambino || clienteAstratto instanceof Anziano){
                    listaAnzianiAndBambini.add(clienteAstratto);
                }
            }
        }   
        Collections.sort(listaAnzianiAndBambini, ClienteAstratto.COMPARATORE_ETA);
        listaAnzianiAndBambini.forEach(System.out :: println);    
    }   
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printArchivioSoloBambiniAnzianiOrdinatoPerEtaSync() {
        readLock();
        printArchivioSoloBambiniAnzianiOrdinatoPerEta();
        readUnlock();
    }     
       
}
