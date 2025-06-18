// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Cliente;

public class Consumatore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Consumatore(Archivio archivio, String nome) {
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
        return "Consumatore{" + "arhivio=" + archivio + ", nome=" + nome + '}';
    }
    
    // Metodo Utilizzato dal Thread Consumatore T2
    @Override
    public void run() {
      
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 8000; 

        while(true){

            try {
                // tempo di elaborazione dei dati successivo alla cancellazione
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Cancellatore " + nome + " Interrotto!");                          
            }   
            
            Cliente cliente = archivio.removeCliente();
            System.out.println("[THREAD CANCELLATORE " + nome + " ] Cancellato Il Cliente: " + cliente);
        }
    }
}
