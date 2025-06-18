// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class Lettore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;

    
    // COSTRUTTORI
    public Lettore(Archivio archivio, String nome) {
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
        return "Lettore{" + "archivio=" + archivio + ", nome=" + nome + '}';
    }

    // Metodo Utilizzato dl Thread Lettore (T2, T3 e T4)
    @Override
    public void run() {
      
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 8000; 
       
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Lettore" + nome + "Interrotto!");                        
            }  
            
            // operazione di lettura
            System.out.println("[THREAD LETTORE " + nome + "]: Letti gli Acquisti!");
            archivio.printArhivioSync();
        }    
                   
    }
}