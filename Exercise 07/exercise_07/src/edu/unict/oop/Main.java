// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.model.Archivio;
import edu.unict.oop.thread.Consumatore;
import edu.unict.oop.thread.LettoreClienti;
import edu.unict.oop.thread.LettoreGestanti;
import edu.unict.oop.thread.Produttore;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Inizio Programma!\n");
        
        // Si Instanza un oggetto Archivio
        Archivio archivio = new Archivio();
        
        // Si Instanziano i Thread
        
         // --> Si instanzia il Thread Produttore T1 <--
        Thread produttoreT1 = new Thread(new Produttore(archivio, "T1"));

        // --> Si instanzia il Thread Lettore T2 <--
        Thread consumatoreT2 = new Thread(new Consumatore(archivio, "T2"));        

        // --> Si instanzia il Thread Lettore T3 <--
        Thread lettoreClientiT3 = new Thread(new LettoreClienti(archivio,"T3")); 
        
        // --> Si instanzia il Thread Lettore T4 <--
        Thread lettoreGestantiT4 = new Thread(new LettoreGestanti(archivio,"T4"));    
       
        // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
        lettoreClientiT3.start();
        produttoreT1.start();
        consumatoreT2.start();
        lettoreGestantiT4.start();

    }       
    
}
