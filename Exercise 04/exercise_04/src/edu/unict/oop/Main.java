// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.model.Archivio;
import edu.unict.oop.thread.Cancellatore;
import edu.unict.oop.thread.Lettore;
import edu.unict.oop.thread.Scrittore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inizio Programma!\n");
        
        // Si instanzia l'oggetto Archivio
        Archivio archivio = new Archivio();
        
        // Si instanziano i Thread
        
        // --> Si instanzia il Thread Produttore T1 <--
        Thread scrittoreT1 = new Thread(new Scrittore(archivio, "T1"));

        // --> Si instanzia il Thread Lettore T2 <--
        Thread lettoreT2 = new Thread(new Lettore(archivio, "T2"));        

        // --> Si instanzia il Thread Lettore T3 <--
        Thread lettoreT3 = new Thread(new Lettore(archivio,"T3")); 
        
        // --> Si instanzia il Thread Lettore T4 <--
        Thread lettoreT4 = new Thread(new Lettore(archivio,"T4"));    
        
        // --> Si instanzia il Thread Cancellatore T5 <--
        Thread cancellatoreT5 = new Thread(new Cancellatore(archivio, "T5"));
        
        // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
        scrittoreT1.start(); 
        lettoreT2.start(); 
        lettoreT3.start(); 
        lettoreT4.start();
        cancellatoreT5.start(); 
    }
    
}
