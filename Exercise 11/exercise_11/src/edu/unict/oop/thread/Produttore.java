// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.ArchivioSemplificato;
import edu.unict.oop.model.VisitatoreSemplificato;
import java.util.Random;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final ArchivioSemplificato archivioSemplificato;
    private final String nome;
    
    // COSTRUTTORE
    public Produttore(ArchivioSemplificato archivioSemplificato, String nome) {
        this.archivioSemplificato = archivioSemplificato;
        this.nome = nome;
    }
    
    // GETTER
    public ArchivioSemplificato getArchivioSemplificato() {
        return archivioSemplificato;
    }

    public String getNome() {
        return nome;
    }
    
    // toString
    @Override
    public String toString() {
        return "Produttore{" + "archivioSemplificato=" + archivioSemplificato + ", nome=" + nome + '}';
    }  
    
    @Override
    public void run() {
        
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 5000; 

        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Produttore " + nome + " Interrotto!");                          
            }  
            
            Random random = new Random();
            
            // range Visitatori da Inserire
            int minVisitatori = 1;
            int maxVisitatori = 10;
            
            // generatore casuale Visitatori da Inserire
            int visitatori = random.nextInt(maxVisitatori + minVisitatori) + minVisitatori;
                      
            for(int i=0; i<visitatori; i++){
                
                try {
                    VisitatoreSemplificato visitatoreSemplificato = new VisitatoreSemplificato("visitatore" + null, 0);
                    int ultimoIndice = archivioSemplificato.getArchivioSemplificato().lastIndexOf(visitatoreSemplificato);
                    visitatoreSemplificato.setNumeroIdentificativo(ultimoIndice+1);
                    archivioSemplificato.addVisitatore(visitatoreSemplificato);      
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunto Visitatore: " + visitatoreSemplificato); 
                    
                }catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }    
            }
        }
    }
           
}
