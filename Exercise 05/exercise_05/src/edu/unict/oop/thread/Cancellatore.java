// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Acquisto;
import edu.unict.oop.model.Archivio;

public class Cancellatore implements Runnable {
    
    // ATTRIBUTO
    private final Archivio archivio;
    private final String name;

    // COSTRUTTORI
    public Cancellatore(Archivio archivio, String name) {
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
        return "Cancellatore{" + "archivio=" + archivio + ", name=" + name + '}';
    }

    
    // Metodo Utilizzato dal Thread Cancellatore (T3 e T4)
    @Override
    public void run() {
        
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 8000;
        
        while(true){

            try {
            	// tempo di elaborazione dei dati successivo alla cancellazione
            	Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));

            } catch (InterruptedException ex) {
            	System.out.println("Thread Cancellatore " + name + " Interrotto!");
            }  

            // operazione di cancellazione
            Acquisto acquisto = archivio.removeAlbero();
            System.out.println("[THREAD CANCELLATORE " + name + "] Cancellato l'Acquisto: " + acquisto);
        }   
    }
}
