// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class LettoreAnzianiAndBambini implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public LettoreAnzianiAndBambini(Archivio archivio, String nome) {
        this.archivio = archivio;
        this.nome = nome;
    }
    
    // GETTER
    public Archivio getArhivio() {
        return archivio;
    }

    public String getNome() {
        return nome;
    }
    
    // toString
    @Override
    public String toString() {
        return "LettoreAnzianiAndBambini{" + "archivio=" + archivio + ", nome=" + nome + '}';
    }
    
    // Metodo Utilizzato dal Thread Lettore Clienti T3
    @Override
    public void run() {
        
        int tempoMinimoSleep = 2000;
        int tempoMassimoSleep = 3000; 
       
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Lettore Anziano & Bambini " + nome + " Interrotto!");                        
            }        
            
            // operazione di lettura
            System.out.println("[THREAD LETTORE ANZIANI & BAMBINI " + nome + "] Letti i Clienti!");
            archivio.printArchivioOrdinatoPerCognomeSync();
        }
    }
    
}