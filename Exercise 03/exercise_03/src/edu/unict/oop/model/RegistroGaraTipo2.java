// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class RegistroGaraTipo2 {
    
    // COSTANTI
    private static final int MAX = 8;
    
    // ATTRIBUTI
    private final Map<Integer, IscrizioneGara> registroGaraTipo2;
    private int readCount;
    
    // COSTRUTTORI
    public RegistroGaraTipo2() {
        registroGaraTipo2 = new HashMap<Integer, IscrizioneGara>(MAX);
    }
    
    // GETTER
    public Map<Integer, IscrizioneGara> getRegistroGaraTipo2() {
        return registroGaraTipo2;
    }

    public int getReadCount() {
        return readCount;
    }
  
    // toString
    @Override
    public String toString() {
        return "RegistroGaraTipo2{" + "registroGaraTipo2=" + registroGaraTipo2 + '}';
    }
    
    // Metodo Sincronizzato per Afggiungere una Prenotazone d un Iscritto della Piscina ad una Gara (se non già presente)
    public synchronized void addPrenotazione(IscrizioneGara iscrizioneGara) throws EccezioneOperazioneIrrealizzabile {
    
        // Attesa solo se la coda è piena o se c'è almeno un lettore
        while(registroGaraTipo2.size() == MAX || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }    
        
        if(registroGaraTipo2.containsKey(iscrizioneGara.getIscrizione().getCodiceUtente())){
            throw new EccezioneOperazioneIrrealizzabile("Utente gia Prenotato");
        } else{
            registroGaraTipo2.put(iscrizioneGara.getIscrizione().getCodiceUtente(), iscrizioneGara);
            notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa
        }   
    }
    
    // Metodo Sincronizzato per Rimuovere un Prenotazione di un Iscritto alla Piscina ad una Gara (se prenotato)
    public synchronized IscrizioneGara removePrenotazione(){
 
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(registroGaraTipo2.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        int codiceUtente = registroGaraTipo2.keySet().iterator().next();
        IscrizioneGara iscrizioneGara = registroGaraTipo2.remove(codiceUtente);
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa 
        return iscrizioneGara;
    }
    
    // Metodo Sincronizzato per Rimuovere un Prenotazione di un Iscritto alla Piscina ad una Gara (se prenotato)
    public synchronized void deleteAllPrenotazioni(){
 
        // Attesa solo se la coda è vuota o se c'è almeno un lettore
        while(registroGaraTipo2.isEmpty() || readCount > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
  
        registroGaraTipo2.clear();
        notifyAll(); // ATTENZIONE: la Notifica è importante per risvegliare i Thread in attesa 
        
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
    
    // Metodo per Stampare il Registro Gara e Calcolare la Media di Età
    public void printRegistroGaraTipo1_And_EtaMedia(){
        if(registroGaraTipo2.isEmpty()){
            System.out.println("Non sono presenti Prenotati per la Gara Tipo 2!");
        } else{
            double sommaEta = 0;
            System.out.println("\nI Clienti Iscritti che sono Prenotati alla Gara Under 18 di Tipo 2 sono: ");
            for (int codiceUtente : registroGaraTipo2.keySet()) {
                System.out.println(registroGaraTipo2.get(codiceUtente));
                
                LocalDate dataAttuale = LocalDate.now();
                LocalDate dataDiNascita = registroGaraTipo2.get(codiceUtente).getIscrizione().getCliente().getDataDiNascita();           
                long etàUtente = dataDiNascita.until(dataAttuale,ChronoUnit.YEARS);       
                sommaEta = sommaEta + etàUtente;    
            } 
            double mediaEta = sommaEta / registroGaraTipo2.size();
            System.out.println("L'Età Media dei Clienti Iscritti che sono Prenotati alla Gara Under 18 di Tipo 1 è: " + mediaEta);           
        }  
    }
    
    // Metodo utilizzato per l'accesso concorrente in lettura
    public void printRegistroGaraTipo1_And_EtaMedia_Sync() {
        readLock();
        printRegistroGaraTipo1_And_EtaMedia();
        readUnlock();        
    }    
      
}
