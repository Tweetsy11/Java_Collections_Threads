// PACKAGE
package edu.unict.oop;

import edu.unict.oop.model.Archivio;
import edu.unict.oop.thread.Cancellatore;
import edu.unict.oop.thread.Lettore;
import edu.unict.oop.thread.Produttore;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Inizio Programma!\n");
        
        // Si instanzia l'oggetto Archivio
        Archivio archivio = new Archivio();
        
        // Si instanziano i Thread
        
        // --> Si instanzia il Thread Produttore T1 <--
        Thread produttoreT1 = new Thread(new Produttore(archivio, "T1"));
        
         // --> Si instanzia il Thread Produttore T2 <--
        Thread produttoreT2 = new Thread(new Produttore(archivio, "T2"));      
        
        // --> Si instanzia il Thread Cancellatore T3 <--
        Thread cancellatoreT3 = new Thread(new Cancellatore(archivio, "T3"));
       
        // --> Si instanzia il Thread Cancellatore T3 <--
        Thread cancellatoreT4 = new Thread(new Cancellatore(archivio, "T4"));
     
        // --> Si instanzia il Thread Lettore T5 <--
        Thread lettoreT5 = new Thread(new Lettore(archivio,"T5"));        
        
        // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
        produttoreT1.start(); 
        produttoreT2.start();             
        cancellatoreT4.start(); 
        cancellatoreT3.start(); 
        lettoreT5.start();  

    }
    
}
