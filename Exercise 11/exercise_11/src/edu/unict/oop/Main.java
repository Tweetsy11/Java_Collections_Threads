// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Adulto;
import edu.unict.oop.model.Anziano;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.ArchivioSemplificato;
import edu.unict.oop.model.Bambino;
import edu.unict.oop.thread.Cancellatore;
import edu.unict.oop.thread.Lettore;
import edu.unict.oop.thread.Produttore;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EccezioneOperazioneIrrealizzabile  {
        System.out.println("Inizio Programma!\n");
        
        System.out.println("Scegli un'Opzione di Avviamento del Programma:");
        System.out.println(" - Digita il numero 1 per Avviare il Programma in Maniera Stardard.");
        System.out.println(" - Digita il numero 2 per Avviare il Programma con l'uso di Thread.");
        Scanner scanner = new Scanner(System.in);
        int opzione = scanner.nextInt();
        
 
        switch(opzione) {
            case 1:

                // Si instanzia l'oggetto Archivio
                Archivio archivio = new Archivio();

                // Si Aggiungono Visitatori all'Archivio
                try {
                    Bambino bambino = new Bambino("Mario Rossi", 5, "biglietto1", 01, 20);
                    archivio.addVisitatore(bambino);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }

               try {
                    Bambino bambino = new Bambino("Luca Bianchi", 8, "biglietto2", 02, 20);
                    archivio.addVisitatore(bambino);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }

                try {
                    Anziano anziano = new Anziano("Giulio Verdi", 80, "biglietto3", 03, 20);
                    archivio.addVisitatore(anziano);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }                

                try {
                    Adulto adulto = new Adulto("Giacomo Neri", 40, "biglietto4", 04, 20);
                    archivio.addVisitatore(adulto);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }                  

                // Si stampa l'Archivio
                archivio.printArchivio();

                // Si Elimina un Visitatore dall'Archivio
                try {
                    archivio.removeVisitatore(04);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }  

                // Si stampa l'Archivio
                archivio.printArchivio();

                // Si cerca un Visitatore nell'Archivio
                try {
                    archivio.searchVisitatore(02);

                } catch(EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage());
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }  

                System.out.println("Il Visitatore con il Biglietto con il Dato Identificativo 02 è: ");
                System.out.println(archivio.searchVisitatore(02));

                break;

            case 2:
                // Si instanzia l'oggetto Archivio Semplificato
                ArchivioSemplificato archivioSemplificato = new ArchivioSemplificato();

                // Si instanziano i Thread

                // --> Si instanzia il Thread Produttore T1 <--
                Thread produttoreT1 = new Thread(new Produttore(archivioSemplificato, "T1"));

                // --> Si instanzia il Thread Produttore T2 <--
                Thread produttoreT2 = new Thread(new Produttore(archivioSemplificato, "T2"));

                // --> Si instanzia il Thread Cancellatore T3 <--
                Thread produttoreT3 = new Thread(new Cancellatore(archivioSemplificato, "T3"));     

                // --> Si instanzia il Thread Cancellatore T4 <--
                Thread cancellatoreT4 = new Thread(new Cancellatore(archivioSemplificato, "T4"));           

                // --> Si instanzia il Thread Cancellatore T5 <--
                Thread cancellatoreT5 = new Thread(new Cancellatore(archivioSemplificato, "T5"));   

                // --> Si instanzia il Thread Lettore T6 <--
                Thread lettoreT6 = new Thread(new Lettore(archivioSemplificato, "T6"));        

                // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
                produttoreT1.start(); 
                produttoreT2.start(); 
                produttoreT3.start(); 
                cancellatoreT4.start();    
                cancellatoreT5.start(); 
                lettoreT6.start();  

                break;
            default:
        }
      
    }
    
}
