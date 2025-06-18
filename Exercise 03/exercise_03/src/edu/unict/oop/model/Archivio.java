// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Archivio {
    
    // ATTRIBUTI
    private final Map<Integer, Iscrizione> archivio;
    
    // COSTRUTTORE
    public Archivio() {
        archivio = new HashMap<Integer, Iscrizione>();
    }
    
    // GETTER
    public Map<Integer, Iscrizione> getArchivio() {
        return archivio;
    }
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + '}';
    }
    
    // Metodo che Iscrive un Cliente alla Piscina (Se non già iscritto)
    public void addCliente(Iscrizione iscrizione) throws EccezioneOperazioneIrrealizzabile {
        if(iscrizione == null){
            throw new EccezioneOperazioneIrrealizzabile("\nIscrizione da Aggiungere NON SPECIFICATA!");
        }
        
       Iscrizione iscrizioneEsistente = archivio.get(iscrizione.getCodiceUtente());
       if(iscrizioneEsistente == null){
          archivio.put(iscrizione.getCodiceUtente(), iscrizione);
       } else{ 
          throw new EccezioneOperazioneIrrealizzabile("\nCodice Utente già Usato"); 
       }       
    }
       
    // Metodo che Legge un Iscritto dell'Archivio della Piscina in base al Codice Utente
    public void searchCliente(int codiceUtenteDaTrovare) throws EccezioneOperazioneIrrealizzabile {
       Iscrizione iscrizioneEsistente = archivio.get(codiceUtenteDaTrovare);
       if(iscrizioneEsistente != null){
           System.out.println("\nL'Utente con il il Codice Utente " + codiceUtenteDaTrovare + " è: " + iscrizioneEsistente.getCliente());
       } else{ 
          throw new EccezioneOperazioneIrrealizzabile("\nCodice Utente NON Trovato!"); 
       }          
    }
   
    // Metodo che Rimuove un Cliente dalla Piscina (se iscritto)
    public void removeCliente(int codiceUtente) throws EccezioneOperazioneIrrealizzabile {
        Iscrizione iscrizioneEsistente = archivio.get(codiceUtente);
        if(iscrizioneEsistente == null){
            throw new EccezioneOperazioneIrrealizzabile("Codice Utente Inesistente!");
        } else if(archivio.isEmpty()){
            throw new EccezioneOperazioneIrrealizzabile("NON sono presenti Iscrizioni in Piscina!");
        } else{
            archivio.remove(codiceUtente);
            System.out.println("\nL'Utente " + iscrizioneEsistente.getCliente() + " è stato Rimosso dall'Archivio.");
        }       
    }
            
    // Metodo che Inserisce all'Interno di una Collezione tutti i Clienti
    // con Eta inferiore a 18 e Abilità Avanzato (Livello da 1 a 4)
    public TreeMap<Integer, Iscrizione> getClientiMinorenniAvanzati(){ 
        
        // [OPZIONE CON ARRAYLIST] List<Iscrizione> listaClientiMinorenniAvanzati = new ArrayList<Iscrizione>(); 
        TreeMap<Integer, Iscrizione> listaClientiMinorenniAvanzati = new TreeMap<Integer, Iscrizione>();
        
        for(int codiceUtente : archivio.keySet()){
            
            LocalDate dataAttuale = LocalDate.now();
            LocalDate dataDiNascita = archivio.get(codiceUtente).getCliente().getDataDiNascita();           
            long differenzaInGiorni = dataDiNascita.until(dataAttuale,ChronoUnit.DAYS); 
            long differenzaInAnni = differenzaInGiorni / 365;
            
            if(differenzaInAnni < 18 && archivio.get(codiceUtente).getLivelloAbilita().getLivello() <= 4 && archivio.get(codiceUtente).getLivelloAbilita().getLivello() >= 1){
                // [OPZIONE CON ARRAYLIST] listaClientiMinorenniAvanzati.add(archivio.get(codiceUtente));
                listaClientiMinorenniAvanzati.put(codiceUtente, archivio.get(codiceUtente));
            }
        }
        return listaClientiMinorenniAvanzati;       
    }
    
    // Metodo che Stampa l'Intero Archivio
    public void printArchivio(){
        if(archivio.isEmpty()){
            System.out.println("\nNON sono presenti Clienti attualmente Iscritti in Archivio!");
        } else{
            System.out.println("\nI Clienti attulamente Iscritti in Archivio sono: ");
            for(int codiceUtente : archivio.keySet()){
                System.out.println(archivio.get(codiceUtente));
            }            
        }
    } 
   
}
