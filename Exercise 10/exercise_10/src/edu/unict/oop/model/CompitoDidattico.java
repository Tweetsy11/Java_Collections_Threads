// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class CompitoDidattico {
    
    // ATTRIBUTI
    private final String nome;
    private int numeroStudenti;
    private final String nomeInsegnamento;
    
    // COSTRUTTORI
    public CompitoDidattico(String nome, int numeroStudenti, String nomeInsegnamento) throws EccezioneOperazioneIrrealizzabile {
        this.nome = nome;
        setNumeroStudenti(numeroStudenti);
        this.nomeInsegnamento = nomeInsegnamento;
    }
    
    // GETTER
    public String getNome() {
        return nome;
    }

    public int getNumeroStudenti() {
        return numeroStudenti;
    }

    public String getNomeInsegnamento() {
        return nomeInsegnamento;
    }
    
    // SETTER
    public void setNumeroStudenti(int numeroStudenti) throws EccezioneOperazioneIrrealizzabile {
        if(numeroStudenti < 0){
            throw new EccezioneOperazioneIrrealizzabile("Un'aula NON può non avere studenti!");
        } else{
            this.numeroStudenti = numeroStudenti;
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "CompitoDidattico{" + "nome=" + nome + ", numeroStudenti=" + numeroStudenti 
                    + ", nomeInsegnamento=" + nomeInsegnamento + '}';
    }
      
}
