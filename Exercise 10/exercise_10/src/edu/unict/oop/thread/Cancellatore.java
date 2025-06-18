// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.model.Archivio;

public class Cancellatore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Cancellatore(Archivio archivio, String nome) {
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
        return "Cancellatore{" + "archivio=" + archivio + ", nome=" + nome + '}';
    }

    @Override
    public void run() {
        
    }
    
}
