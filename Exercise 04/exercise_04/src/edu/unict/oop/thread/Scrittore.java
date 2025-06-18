// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Acquisto;
import edu.unict.oop.model.Adulto;
import edu.unict.oop.model.Anziano;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Bambino;
import java.util.Random;

public class Scrittore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Scrittore(Archivio archivio, String nome) {
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
        return "Scrittore{" + "archivio=" + archivio + ", nome=" + nome + '}';     
    }

    // Metodo Utilizzato dl Thread Scrittore (T1)
    @Override
    public void run() {
        
       int tempoMinimoSleep = 3000;
       int tempoMassimoSleep = 5000; 
       
       int n = 0;
       
       while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Scrittore" + nome + "Interrotto!");                          
            }       
            
            Random random = new Random();
            
            // range di valori Opzioni Di Acquisto
            int minOpzioneDiAcquisto = 1;
            int maxOpzioneDiAcquisto = 3;
            int opzioneDiAcquisto = random.nextInt(maxOpzioneDiAcquisto + minOpzioneDiAcquisto) + minOpzioneDiAcquisto;
            
            // range di valori Eta Bambino
            int minEtaBambino = 1;
            int maxEtaBambino = 10;
            
            // range di valori Eta Adulto
            int minEtaAdulto = 11;
            int maxEtaAdulto = 65;
            
            // range di valori Eta Anziano
            int minEtaAnziano = 66;
            int maxEtaAnziano = 100;
            
            // instanza degli acquisti dei biglietti degli utenti
            if(opzioneDiAcquisto == 1){
                
                try {
                    n++;
                    int etaBambino = random.nextInt(maxEtaBambino + minEtaBambino) + minEtaBambino;
                    Bambino bambino = new Bambino("nome" + n, "cognome" + n, etaBambino, "mailBambino" + n + "@gmail.com");
                    Acquisto acquistoBiglietto = new Acquisto(bambino);
                    double prezzoFinale = acquistoBiglietto.Sconto();
                    acquistoBiglietto.getUtente().setPrezzo(prezzoFinale);
                    archivio.addUtente(acquistoBiglietto);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Creato l'Acquisto: " + acquistoBiglietto);
                 
                } catch (EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage()); 
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            
            if(opzioneDiAcquisto == 2){
                
                try {
                    n++;
                    int etaAdulto = random.nextInt(maxEtaAdulto + minEtaAdulto) + minEtaAdulto;
                    Adulto adulto = new Adulto("nome" + n, "cognome" + n, etaAdulto, "mailAdulto" + n + "@gmail.com");
                    Acquisto acquistoBiglietto = new Acquisto(adulto);
                    double prezzoFinale = acquistoBiglietto.Sconto();
                    acquistoBiglietto.getUtente().setPrezzo(prezzoFinale);
                    archivio.addUtente(acquistoBiglietto);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Creato l'Acquisto: " + acquistoBiglietto);
                    
                } catch (EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage()); 
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            
            if(opzioneDiAcquisto == 3){
                
                try {
                    n++;
                    int etaAnziano = random.nextInt(maxEtaAnziano + minEtaAnziano) + minEtaAnziano;
                    Anziano anziano = new Anziano("nome" + n, "cognome" + n, etaAnziano, "mailAnziano" + n + "@gmail.com");
                    Acquisto acquistoBiglietto = new Acquisto(anziano);
                    double prezzoFinale = acquistoBiglietto.Sconto();
                    acquistoBiglietto.getUtente().setPrezzo(prezzoFinale);
                    archivio.addUtente(acquistoBiglietto);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Creato l'Acquisto: " + acquistoBiglietto);
            
                } catch (EccezioneOperazioneIrrealizzabile ex) {
                    System.err.println(ex.getMessage()); 
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }                    
            } 
       }
    }   
}
