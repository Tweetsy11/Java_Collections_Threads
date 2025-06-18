// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.enumerations.TipiCorso;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Cliente;
import edu.unict.oop.model.Corso;
import edu.unict.oop.model.Gestante;
import edu.unict.oop.model.Pulcino;
import java.util.List;

public class Main {

    public static void main(String[] args)  {
        
        System.out.println("Inizio Programma!\n");
        
        // Si instanzia un Oggetto Archivio
        Archivio archivio = new Archivio();
        
        // Si Aggiungono alcuni Clienti all'Archivio
        try {
            Cliente cliente = new Cliente("Rossi", 30, "ABC1234");
            archivio.addCliente(cliente);
                     
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        } 
         
        try {
            Pulcino pulcino = new Pulcino("Verdi", 3, "DEF1234");
            archivio.addCliente(pulcino);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        } 
        
        try {
            Pulcino pulcino = new Pulcino("Neri", 2, "GHI1234");
            archivio.addCliente(pulcino);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        } 
        
        try {
            Gestante gestante = new Gestante("Rosa", 2, "LMN1234");
            archivio.addCliente(gestante);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        }         
        
        // Si Stampa l'Archivio
        archivio.printArchivio();
        
        // Si Rimuove un Cliente dall'Archivio
        try {
            archivio.removeCliente("ABC1234");
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        }             
        
        // Si Stampa l'Archivio
        archivio.printArchivio();
        
        // Si Iscrivono i Clienti in Archivio ad un Corso
        try {        
            Corso corso = new Corso(TipiCorso.CORSO_BASE);
            archivio.iscrizioneCliente("DEF1234", corso);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        }         
              
        try {        
            Corso corso = new Corso(TipiCorso.PALESTRA_GIOCHI);
            archivio.iscrizioneCliente("GHI1234", corso);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        }       
        
        try {        
            Corso corso = new Corso(TipiCorso.CORSO_GESTANTI);
            archivio.iscrizioneCliente("LMN1234", corso);
        } catch (EccezioneOperazioneIrrealizzabile ex){
           System.err.println(ex.getMessage()); 
        } catch(Exception e) {
            System.err.println(e.getMessage());            
        } 
        
        // Si Stampa l'Archivio
        archivio.printArchivio();
        
        // Si fornisce una Lista Ordinata per Età di tutti i Pulcini della HashMap
        List<Pulcino> listaPulcini = archivio.PulciniOrdinati();
        archivio.printPulciniOrdinati(listaPulcini); 
        
        System.out.println("\nFine Programma!");
           
    }
    
}
