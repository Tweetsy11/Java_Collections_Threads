// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class LettoreClienti implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public LettoreClienti(Archivio arhivio, String nome) {
        this.archivio = arhivio;
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
        return "LettoreClienti{" + "arhivio=" + archivio + ", nome=" + nome + '}';
    }
    
    // Metodo Utilizzato dal Thread Lettore Clienti T3
    @Override
    public void run() {
        
        int tempoMinimoSleep = 5000;
        int tempoMassimoSleep = 7000; 
       
        while(true){
            
            try {
                // tempo di elaborazione per elaborare i dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Lettore Clienti " + nome + " Interrotto!");                        
            }        
            
            // operazione di lettura
            System.out.println("[THREAD LETTORE CLIENTI " + nome + "] Letti i Clienti!");
            archivio.printArchivioOrdinatoPerCognomeSync();
        }
    }
    
}