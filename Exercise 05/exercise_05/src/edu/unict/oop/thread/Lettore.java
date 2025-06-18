// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class Lettore implements Runnable {
    
    // ATTRIBUTO
    private final Archivio archivio;
    private final String name;

    // COSTRUTTORI
    public Lettore(Archivio archivio, String name) {
        this.archivio = archivio;
        this.name = name;
    }
    
    // GETTER
    public Archivio getArchivio() {
        return archivio;
    }

    public String getName() {
        return name;
    }
    
    // toString
    @Override
    public String toString() {
        return "Lettore{" + "archivio=" + archivio + ", name=" + name + '}';
    }

    // Metodo Utilizzato dal Thread Lettore (T5)
    @Override
    public void run() {
        
        int sleep = 20000;
        
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)sleep);
            } catch (InterruptedException ex) {
                System.out.println("Thread Lettore " + name + " Interrotto!");    
            }
            
            // operazione di lettura
            System.out.println("[THREAD LETTORE " + name + "]: Letti gli Acquisti!");
            archivio.printArchivioSync();            
            
        }    
    }
}

