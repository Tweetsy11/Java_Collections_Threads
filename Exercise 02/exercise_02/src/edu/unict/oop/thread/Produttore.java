// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.enumerations.TipiPosto;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Buffer;
import edu.unict.oop.model.Seat;
import java.util.Random;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final Buffer buffer;
    private final String nome;
    
    // COSTRUTTORI
    public Produttore(Buffer buffer, String nome) {
        this.buffer = buffer;
        this.nome = nome;
    }
    
    // GETTER
    public Buffer getBuffer() {
        return buffer;
    }

    public String getNome() {
        return nome;
    }
    
    // toString
    @Override
    public String toString() {
        return "Produttore{" + "buffer=" + buffer + ", nome=" + nome + '}';
    }

    // Generatore casuale TipiFasciaPosto
    private TipiPosto randomTipiPosto() {
        int pick = new Random().nextInt(TipiPosto.values().length);
        return TipiPosto.values()[pick];
    }  

    // Metodo Utilizzato dal Thread Produttore
    @Override
    public void run() {
      
        int tempoMinimoSleep = 1000;
        int tempoMassimoSleep = 3000; 
        
        int n = 0;
        
        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Produttore " + nome + " Interrotto!");                          
            }  
               
            try {   
                n++;
                TipiPosto posto = randomTipiPosto();
                Seat seat = new Seat("utente" + n, posto);
                System.out.println("\n[THREAD PRODUTTORE " + nome + "] Aggiunto Utente: " + seat); 
                buffer.addUtente(seat);
            } catch (EccezioneOperazioneIrrealizzabile ex) {
                System.err.println(ex.getMessage());
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
            
}
