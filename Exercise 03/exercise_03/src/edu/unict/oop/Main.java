// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.enumerations.LivelliAbilita;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Cliente;
import edu.unict.oop.model.Iscrizione;
import edu.unict.oop.model.RegistroGaraTipo1;
import edu.unict.oop.model.RegistroGaraTipo2;
import edu.unict.oop.thread.Cancellatore;
import edu.unict.oop.thread.Consumatore;
import edu.unict.oop.thread.Lettore;
import edu.unict.oop.thread.Produttore;
import java.time.LocalDate;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Inizio 1°Parte Programma!")
                    ;
        // SVOLGIMENTO 1°PARTE
        
        // Si instanzia un Oggetto Archivio
        Archivio archivio = new Archivio();
        
        // Si Iscrivono alcuni Clienti all'Archivio        
        try {
            LocalDate dataDiNascita1 = LocalDate.of(2007, 12, 10);
            Cliente cliente1 = new Cliente("Mario",dataDiNascita1,"mario@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente1,1,LivelliAbilita.ESPERTO);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            LocalDate dataDiNascita2 = LocalDate.of(2009, 10, 5);
            Cliente cliente2 = new Cliente("Luca",dataDiNascita2,"luca@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente2,2,LivelliAbilita.ESPERTO);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            LocalDate dataDiNascita3 = LocalDate.of(2014, 6, 13);
            Cliente cliente3 = new Cliente("Marco",dataDiNascita3,"marco@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente3,3,LivelliAbilita.ISTRUTTORE);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            LocalDate dataDiNascita4 = LocalDate.of(2020, 8, 4);
            Cliente cliente4 = new Cliente("Gino",dataDiNascita4,"gino@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente4,4,LivelliAbilita.ISTRUTTORE);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            LocalDate dataDiNascita5 = LocalDate.of(2018, 12, 10);
            Cliente cliente5 = new Cliente("Stefano",dataDiNascita5,"stefano@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente5,5,LivelliAbilita.ESPERTO);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }        
        
        try {
            LocalDate dataDiNascita6 = LocalDate.of(2017, 8, 5);
            Cliente cliente4 = new Cliente("Rosario",dataDiNascita6,"rosario@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente4,6,LivelliAbilita.ISTRUTTORE);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }        
        
        try {
            LocalDate dataDiNascita7 = LocalDate.of(2020, 8, 4);
            Cliente cliente4 = new Cliente("Gabriele",dataDiNascita7,"gabriele@gmail.com");
            Iscrizione iscrizione = new Iscrizione(cliente4,7,LivelliAbilita.ESPERTO);
            archivio.addCliente(iscrizione);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }        
        
        // Si Stampa l'Archivio
        archivio.printArchivio();
        
        // Si Ricerca un Cliente con determinato Codice Utente:
        try{
            archivio.searchCliente(03);
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
              
        // Si Rimuove un Cliente attualemente Iscritto dall'Archivio
        try{
            archivio.removeCliente(02);
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }   
        
        // Si Stampa l'Archivio
        archivio.printArchivio(); 
        
        // Si Stampano tutti i Clienti con Eta inferiore a 18 e Abilità Avanzato (Livello da 1 a 4)
        TreeMap<Integer, Iscrizione> listaClientiMinorenniAvanzati = archivio.getClientiMinorenniAvanzati();
        System.out.println("\nLa Lista dei Clienti Eta inferiore a 18 e Abilità Avanzato (Livello da 1 a 4) è: ");
        for(int codiceUtente : archivio.getArchivio().keySet()){
            System.out.println(listaClientiMinorenniAvanzati.get(codiceUtente));
        }               
        
        // ------------------------------------------------------------------------------------------------------------------------------ //
 
        // SVOLGIMENTO 2°PARTE
        System.out.println("\nInizio 2°Parte Programma!");
   
        // Si Instanza un oggetto Archivio
        RegistroGaraTipo1 registroGaraTipo1 = new RegistroGaraTipo1();
        RegistroGaraTipo2 registroGaraTipo2 = new RegistroGaraTipo2();
        
        // Si Instanziano i Thread
              
         // --> Si instanzia il Thread Produttore T1 <--  
        Thread produttore = new Thread(new Produttore(registroGaraTipo1, registroGaraTipo2, "T1", archivio));

        // --> Si instanzia il Thread Lettore T2 <--
        Thread consumatore = new Thread(new Consumatore(registroGaraTipo1, registroGaraTipo2, "T2"));        

        // --> Si instanzia il Thread Lettore T3 <--
        Thread cancellatore = new Thread(new Cancellatore(registroGaraTipo1, registroGaraTipo2,"T3")); 
        
        // --> Si instanzia il Thread Lettore T4 <--
        Thread lettore = new Thread(new Lettore(registroGaraTipo1, registroGaraTipo2,"T4"));
       
        // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
        produttore.start();
        consumatore.start();
        cancellatore.start();
        lettore.start();  
 
    }
}
