// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.RegistroGaraTipo1;
import edu.unict.oop.model.RegistroGaraTipo2;
import java.util.Random;

public class Cancellatore implements Runnable {
    
    // ATTRIBUTI
    private final RegistroGaraTipo1 registroGara1;
    private final RegistroGaraTipo2 registroGara2;
    private final String nome;
    
    // COSTRUTTORI
    public Cancellatore(RegistroGaraTipo1 registroGara1, RegistroGaraTipo2 registroGara2, String nome) {
        this.registroGara1 = registroGara1;
        this.registroGara2 = registroGara2;
        this.nome = nome;
    }
    
    // GETTER
    public RegistroGaraTipo1 getRegistroGara1() {
        return registroGara1;
    }

    public RegistroGaraTipo2 getRegistroGara2() {
        return registroGara2;
    }  

    public String getNome() {
        return nome;
    }
    
    // toString
    @Override
    public String toString() {
        return "Cancellatore{" + "registroGara1=" + registroGara1 
                    + ", registroGara2=" + registroGara2 + ", nome=" + nome + '}';
    }

    // Metodo Utilizzato dal Thread Cancellatore
    @Override
    public void run() {
      
        int tempoSleep = 5000;
        
        while(true){

            try {
                // tempo di elaborazione dei dati successivo alla cancellazione
                Thread.sleep(tempoSleep);
            } catch (InterruptedException ex) {
                System.out.println("Thread Cancellatore " + nome + " Interrotto!");                          
            }   
         
            Random random = new Random();  
   
            // range di valori scelta Opzione di Gara
            int minOpzioneDiGara = 1;
            int maxOpzioneDiGara = 2;
            
            // generatore casuale     
            int opzioneDiGara = random.nextInt(maxOpzioneDiGara + minOpzioneDiGara) + minOpzioneDiGara; 
            
            if(opzioneDiGara == 1){
                registroGara1.deleteAllPrenotazioni();
                System.out.println("\n[THREAD CANCELLATORE " + nome + "] Cancellate tutte le Prenotazioni della Gara di Tipo 1!");     
            } else {
                registroGara2.deleteAllPrenotazioni();
                System.out.println("\n[THREAD CANCELLATORE " + nome + "] Cancellate tutte le Prenotazioni della Gara di Tipo 1!");  
            }
        }             
    }

}