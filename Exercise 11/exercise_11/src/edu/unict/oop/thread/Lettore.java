// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.ArchivioSemplificato;

public class Lettore implements Runnable {
    
    // ATTRIBUTI
    private final ArchivioSemplificato archivioSemplificato;
    private final String nome;
    
    // COSTRUTTORE
    public Lettore(ArchivioSemplificato archivioSemplificato, String nome) {
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
        return "Lettore{" + "archivioSemplificato=" + archivioSemplificato + ", nome=" + nome + '}';
    }

    @Override
    public void run() {
            
        int sleep = 20000;
        
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)sleep);
            } catch (InterruptedException ex) {
                System.out.println("Thread Cancellatore " + nome + " Interrotto!");    
            }       
            
            // operazione di lettura
            System.out.println("[THREAD LETTORE " + nome + "] Letti i Visitatori!");
            archivioSemplificato.printArchivioSemplificatoSync();
            
        }
    }
           
}