// PACKAGE
package edu.unict.oop;

// IMPORT
import edu.unict.oop.enumerations.TipiFasciaPosto;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Abbonamento;
import edu.unict.oop.model.AbbonatoStandard;
import edu.unict.oop.model.Anziano;
import edu.unict.oop.model.Buffer;
import edu.unict.oop.model.StudenteUniversitario;
import edu.unict.oop.model.Teatro;
import edu.unict.oop.thread.Amministratore;
import edu.unict.oop.thread.Consumatore;
import edu.unict.oop.thread.Produttore;
import edu.unict.oop.thread.Segreteria;

public class Main {

    public static void main(String[] args) {
        
        // SVOLGIMENTO 1°PARTE
        System.out.println("Inizio 1°Parte Programma!\n");
        
        // Si instanzia un Oggetto Teatro
        Teatro teatro = new Teatro();
        
        // Si Aggiungono alcuni Abbonamenti al Teatro
        try {
            AbbonatoStandard abbonatoStandard = new AbbonatoStandard("abbonatoStandard n°1",30,"abbonatoStandard01@gmail.com",01);
            Abbonamento abbonamento1 = new Abbonamento(abbonatoStandard, 01, TipiFasciaPosto.GALLERIA, 0);
            double costoAbbonamento1 = abbonamento1.VariazioneCostoAbbonamento();
            abbonamento1.setCostoAbbonamento(costoAbbonamento1);
            teatro.addAbbonamento(abbonamento1);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.err.println(ex.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }

        try {
            StudenteUniversitario studenteUniversitario1 = new StudenteUniversitario("studenteUniversitario n°1",24,"studenteUniversitario01@gmail.com",02);
            Abbonamento abbonamento2 = new Abbonamento(studenteUniversitario1, 02, TipiFasciaPosto.NORMALI,0);
            double costoAbbonamento2 = abbonamento2.VariazioneCostoAbbonamento();
            abbonamento2.setCostoAbbonamento(costoAbbonamento2);
            teatro.addAbbonamento(abbonamento2);
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.err.println(ex.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        try {
            Anziano anziano1 = new Anziano("anziano n°1",80,"anziano01@gmail.com",03);
            Abbonamento abbonamento3 = new Abbonamento(anziano1, 02, TipiFasciaPosto.POLTRONISSIME, 0);
            double costoAbbonamento3 = abbonamento3.VariazioneCostoAbbonamento();
            abbonamento3.setCostoAbbonamento(costoAbbonamento3);           
            teatro.addAbbonamento(abbonamento3);
 
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.err.println(ex.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }  
         
        // Si Stampano gli Abbonnamenti del Teatro
        teatro.printTeatro();  
        
        // Si Rimuove un Abbonato dal Teatro 
        try{
            teatro.removeAbbonamento("anziano01@gmail.com");
            
        } catch(EccezioneOperazioneIrrealizzabile ex){
            System.err.println(ex.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }  
    
        // Si Stampano gli Abbonnamenti del Teatro
        teatro.printTeatro();  

        // ----------------------------------------------------------------------------------------------------------------------------------------------------- //        
        
        // SVOLGIMENTO 2°PARTE
        System.out.println("\nInizio 2°Parte Programma!");
        
        // Si Instanza un oggetto Archivio
        Buffer buffer = new Buffer();
        
        // Si Instanziano i Thread
        
         // --> Si instanzia il Thread Produttore T1 <--
        Thread produttore = new Thread(new Produttore(buffer, "T1"));

        // --> Si instanzia il Thread Lettore T2 <--
        Thread consumatore = new Thread(new Consumatore(buffer, "T2"));        

        // --> Si instanzia il Thread Lettore T3 <--
        Thread segretaria = new Thread(new Segreteria(buffer,"T3")); 
        
        // --> Si instanzia il Thread Lettore T4 <--
        Thread amministratore = new Thread(new Amministratore(buffer,"T4"));
       
        // Si Lanciano i Thread (l'ordine con cui far partire i thread non è importante)
        produttore.start();
        consumatore.start();
        segretaria.start();
        amministratore.start();      
        
    }    
}
