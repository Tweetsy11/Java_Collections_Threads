// PACKAGE
package edu.unict.oop.thread;

import edu.unict.oop.model.Buffer;

public class Amministratore implements Runnable {
    
    // ATTRIBUTI
    private final Buffer buffer;
    private final String nome;
    
    // COSTRUTTORI
    public Amministratore(Buffer buffer, String nome) {
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
        return "Amministratore{" + "buffer=" + buffer + ", nome=" + nome + '}';
    }     
    
    // Metodo Utilizzato dal Thread Segreteria
    @Override
    public void run() {
        
        int tempoMinimoSleep = 10000;
        int tempoMassimoSleep =30000; 
       
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Amministratore " + nome + " Interrotto!");                        
            }        
            
            // operazione di lettura
            System.out.println("\n[THREAD AMMINISTRATORE " + nome + "] Calcolato l'Introito Attuale Effettivo Contenuto nel Buffer!");
            buffer.printIntroitoAttualeSync();        
        }     
    }   
}

