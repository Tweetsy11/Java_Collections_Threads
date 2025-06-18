// PACKAGE
package edu.unict.oop.thread;

import edu.unict.oop.model.IscrizioneGara;
import edu.unict.oop.model.RegistroGaraTipo1;
import edu.unict.oop.model.RegistroGaraTipo2;
import java.util.Random;

public class Consumatore implements Runnable {
    
    // ATTRIBUTI
    private final RegistroGaraTipo1 registroGara1;
    private final RegistroGaraTipo2 registroGara2;
    private final String nome;
    
    // COSTRUTTORI
    public Consumatore(RegistroGaraTipo1 registroGara1, RegistroGaraTipo2 registroGara2, String nome) {
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
        return "Consumatore{" + "registroGara1=" + registroGara1 
                    + ", registroGara2=" + registroGara2 + ", nome=" + nome + '}';
    }

    // Metodo Utilizzato dal Thread Consumatore
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
            
            Random random = new Random();  
   
            // range di valori scelta Opzione di Gara
            int minOpzioneDiGara = 1;
            int maxOpzioneDiGara = 2;
            
            // generatore casuale     
            int opzioneDiGara = random.nextInt(maxOpzioneDiGara + minOpzioneDiGara) + minOpzioneDiGara; 
            
            if(opzioneDiGara == 1){
                IscrizioneGara iscrizioneGara = registroGara1.removePrenotazione();
                System.out.println("\n[THREAD CONSUMATORE " + nome + "] Cancellato l'Utente della Gara di Tipo 1: " + iscrizioneGara);    
            } else {
                IscrizioneGara iscrizioneGara = registroGara2.removePrenotazione();
                System.out.println("\n[THREAD CONSUMATORE " + nome + "] Cancellato l'Utente della Gara di Tipo 2: " + iscrizioneGara);  
            }            
                         
        }       
    }
}