// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class Cancellatore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Cancellatore(Archivio archivio, String nome) {
        this.archivio = archivio; 
        this.nome = nome;
    }
    
    // GETTER
    public Archivio getArchivio() {
        return archivio;
    }

    public String getNome() {
        return nome;
    }

    // toString  
    @Override
    public String toString() {
        return "Cancellatore{" + "archivio=" + archivio + ", nome=" + nome + '}';
    }


    // Metodo Utilizzato dl Thread Cancellatore (T5)
    @Override
    public void run() {
       
        int sleep = 20000;
        
        while(true){
            
            try {
                // tempo di elaborazione dei dati successivo alla cancellazione
                Thread.sleep((long)sleep);
            } catch (InterruptedException ex) {
                System.out.println("Thread Cancellatore " + nome + " Interrotto!");    
            }
            
            // operazione di cancellazione
            archivio.removeAllUtente();
            System.out.println("[THREAD CANCELLATORE " + nome + "] Cancellati Tutti gli Acquisti!");             
        }             
    }
    
}
