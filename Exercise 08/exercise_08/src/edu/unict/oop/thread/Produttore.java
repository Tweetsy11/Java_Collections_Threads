// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.enumerations.TipiAbbonamento;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Anziano;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Bambino;
import edu.unict.oop.model.Cliente;
import java.util.Random;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Produttore(Archivio archivio, String nome) {
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
        return "Produttore{" + "archivio=" + archivio + ", nome=" + nome + '}';
    }

    // Generatore casuale TipiSesso
    private TipiAbbonamento randomTipiAbbonamento() {
        int pick = new Random().nextInt(TipiAbbonamento.values().length);
        return TipiAbbonamento.values()[pick];
    }       
    
    @Override
    public void run() {
      
        int tempoMinimoSleep = 4000;
        int tempoMassimoSleep = 6000; 
       
        int n = 0;
        
        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Produttore " + nome + " Interrotto!");                          
            }  
            
            Random random = new Random();
            
            // range di valori Opzione di Cliente
            int minOpzioneDiCliente = 1;
            int maxOpzioneDiCliente = 3;              
            
	    // generatore casuale Opzione di Cliente     
            int opzioneDiCliente = random.nextInt(maxOpzioneDiCliente + minOpzioneDiCliente) + minOpzioneDiCliente;            
           
            // range di valori Eta Bambino
            int minEtaBambino = 3;
            int maxEtaBambino = 6;            
            
            // range di valori Eta Anziano
            int minEtaAnziano = 76;  
            int maxEtaAnziano = 100;
            
            // range di valori Eta Cliente
            int minEtaCliente = 7;
            int maxEtaCliente = 75;                
            
            // instanza dei clienti della palestra
            if(opzioneDiCliente == 1){
                
                try{
                    n++;
                    int etaBambino = random.nextInt(maxEtaBambino + minEtaBambino) + minEtaBambino;     
                    TipiAbbonamento abbonamento = randomTipiAbbonamento(); 
                    Bambino bambino = new Bambino("cognome" + n, etaBambino ,"codiceFiscale" + n, abbonamento);  
                    archivio.addCliente("codiceFiscale" + n, bambino);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunto Cliente: " + bambino);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }
            } 
            
            if(opzioneDiCliente == 2){
                
                try{
                    n++;
                    int etaAnziano = random.nextInt(maxEtaAnziano+ minEtaAnziano) + minEtaAnziano;     
                    TipiAbbonamento abbonamento = randomTipiAbbonamento(); 
                    Anziano anziano = new Anziano("cognome" + n, etaAnziano ,"codiceFiscale" + n, abbonamento);  
                    archivio.addCliente("codiceFiscale" + n, anziano);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunto Cliente: " + anziano);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }
            }             
            
            if(opzioneDiCliente == 3){
                
                try{
                    n++;
                    int etaCliente = random.nextInt(maxEtaCliente + minEtaCliente) + minEtaCliente;     
                    TipiAbbonamento abbonamento = randomTipiAbbonamento(); 
                    Cliente cliente = new Cliente("cognome" + n, etaCliente ,"codiceFiscale" + n, abbonamento);  
                    archivio.addCliente("codiceFiscale" + n, cliente);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunto Cliente: " + cliente);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }
            }                    
        }         
    }
    
}
