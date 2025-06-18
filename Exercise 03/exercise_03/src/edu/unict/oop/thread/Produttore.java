// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Iscrizione;
import edu.unict.oop.model.IscrizioneGara;
import edu.unict.oop.model.RegistroGaraTipo1;
import edu.unict.oop.model.RegistroGaraTipo2;
import edu.unict.oop.model.TipiGara;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final RegistroGaraTipo1 registroGara1;
    private final RegistroGaraTipo2 registroGara2;
    private final String nome;
    private final Archivio archivio;
    
    // COSTRUTTORI
    public Produttore(RegistroGaraTipo1 registroGara1, RegistroGaraTipo2 registroGara2, String nome, Archivio archivio) {
        this.registroGara1 = registroGara1;
        this.registroGara2 = registroGara2;
        this.nome = nome;
        this.archivio = archivio;
    }
    
    // GETTER
    public RegistroGaraTipo1 getRegitroGara1() {
        return registroGara1;
    }

    public RegistroGaraTipo2 getRegistroGara2() {
        return registroGara2;
    }  

    public String getNome() {
        return nome;
    }
    
    // toString
    @Override
    public String toString() {
        return "Produttore{" + "registroGara1=" + registroGara1 
                    + ", registroGara2=" + registroGara2 + ", nome=" + nome + '}';
    }
      
    // Metodo Utilizzato dal Thread Produttore
    @Override
    public void run() {
      
        int tempoMinimoSleep = 1000;
        int tempoMassimoSleep = 3000; 
        
        TreeMap<Integer, Iscrizione> listaClientiMinorenniAvanzati = archivio.getClientiMinorenniAvanzati();
        
        // calcolo del massimo valore delle chiavi della TreeMap
        Set<Integer> keys = listaClientiMinorenniAvanzati.keySet();
        int maxCodice = Integer.MIN_VALUE;

        for (int codiceUtente : keys) {
            if (codiceUtente > maxCodice) {
                maxCodice = codiceUtente;
            }
        }        
           
        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Produttore " + nome + " Interrotto!");                          
            }
            
            Random random = new Random();
            
            // generatore casuale           
            // int codiceUtente = random.nextInt(maxCodice + 1) + 1;
            int codiceUtente = random.nextInt(7 + 1) + 1;
            int opzione = random.nextInt(2 + 1) + 1;
            
            
            // if(opzione == 1 /*archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() >= 3*/){
            if(archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() >= 3){
                try{
                    Iscrizione iscrizione = new Iscrizione(archivio.getArchivio().get(codiceUtente).getCliente(),codiceUtente,archivio.getArchivio().get(codiceUtente).getLivelloAbilita());
                    IscrizioneGara iscrizioneGara = new IscrizioneGara(iscrizione,TipiGara.UNDER18_DA_LIVELLO_da_3_in_su);
                    registroGara1.addPrenotazione(iscrizioneGara);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Iscritto Utente: " + iscrizioneGara);
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                } catch(Exception e){
                    System.err.println(e.getMessage());
                }                  
            }

            // if(opzione == 2 /*archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() > 1 && archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() <= 4*/){
            if(archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() > 1 && archivio.getArchivio().get(codiceUtente).getLivelloAbilita().getLivello() <= 4){
                try{                   
                    Iscrizione iscrizione = new Iscrizione(archivio.getArchivio().get(codiceUtente).getCliente(),codiceUtente,archivio.getArchivio().get(codiceUtente).getLivelloAbilita());
                    IscrizioneGara iscrizioneGara = new IscrizioneGara(iscrizione,TipiGara.UNDER18_DA_LIVELLO_da_1_a_4);
                    registroGara1.addPrenotazione(iscrizioneGara);
                    System.out.println("\n[THREAD PRODUTTORE " + nome + "] Iscritto Utente: " + iscrizioneGara);

                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                } catch(Exception e){
                    System.err.println(e.getMessage());
                }                
            } 
           

        }
    }
}
