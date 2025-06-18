// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Buffer;
import edu.unict.oop.model.Seat;

public class Consumatore implements Runnable {
    
    // ATTRIBUTI
    private final Buffer buffer;
    private final String nome;
    
    // COSTRUTTORI
    public Consumatore(Buffer buffer, String nome) {
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
        return "Consumatore{" + "buffer=" + buffer + ", nome=" + nome + '}';
    }

    // Metodo Utilizzato dal Thred Consumatore
    @Override
    public void run() {
      
        int tempoSleep = 5000;
        
         while(true){

            try {
                // tempo di elaborazione dei dati successivo alla cancellazione
                Thread.sleep(tempoSleep);
            } catch (InterruptedException ex) {
                System.out.println("Thread Consumatore " + nome + " Interrotto!");                          
            }   
            
            Seat seat = buffer.removeUtente();
            System.out.println("\n[THREAD CONSUMATORE " + nome + "] Cancellato l'Utente: " + seat);               
        }       
    }
}
   
    

