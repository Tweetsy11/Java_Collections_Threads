// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.ArchivioSemplificato;
import edu.unict.oop.model.VisitatoreSemplificato;
import java.util.List;

public class Cancellatore implements Runnable {
    
    // ATTRIBUTI
    private final ArchivioSemplificato archivioSemplificato;
    private final String nome;
    
    // COSTRUTTORE
    public Cancellatore(ArchivioSemplificato archivioSemplificato, String nome) {
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
        return "Cancellatore{" + "archivioSemplificato=" + archivioSemplificato + ", nome=" + nome + '}';
    }

    @Override
    public void run() {
        
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 5000; 

        while(true){

            try {
                // tempo di elaborazione dei dati successivo alla cancellazione
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Cancellatore " + nome + " Interrotto!");                          
            }   
                
            List<VisitatoreSemplificato> listaVisitatoriRimossi = archivioSemplificato.removeVisitatore();
            System.out.println("[THREAD CANCELLATORE " + nome + "] Cancellati I Visitatori: ");
            listaVisitatoriRimossi.forEach(System.out :: println);
        }           
                       
    }
}           
