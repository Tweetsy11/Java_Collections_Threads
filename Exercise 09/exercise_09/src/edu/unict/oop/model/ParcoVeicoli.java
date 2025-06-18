// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParcoVeicoli {
    
    // ATTRIBUTI
    private final Map<String, Noleggiamento> parcoVeicoli;
    
    // COSTRUTTORI
    public ParcoVeicoli() {
        this.parcoVeicoli = new HashMap<>();
    }
    
    // GETTER
    public Map<String, Noleggiamento> getParcoVeicoli() {
        return parcoVeicoli;
    }
    
    // toString
    @Override
    public String toString() {
        return "ParcoVeicoli{" + "parcoVeicoli=" + parcoVeicoli + '}';
    }
    
    // Metodo che Inserisce un nuovo veicolo (se non presente) al Parco Veicoli
    public void addVeicolo(Veicolo veicolo) throws EccezioneOperazioneIrrealizzabile {
        if(veicolo == null){
            throw new EccezioneOperazioneIrrealizzabile("Veicolo da Aggiungere NON DISPONIBILE");
        }
        
        Noleggiamento nolleggiamentoEsistente = parcoVeicoli.get(veicolo.getCodiceTelaio());
        if(nolleggiamentoEsistente == null) {
            parcoVeicoli.put(veicolo.getCodiceTelaio(), new Noleggiamento(veicolo, null));
        } else {
            throw new EccezioneOperazioneIrrealizzabile("Codice Telaio già Usato!");
        }
    }
    
    // Metodo che Rimuove un veicolo (gia presente) con un determinato numero di Telaio dal Parco Veicoli
    public Veicolo removeVeicolo(String codiceTelaio) throws EccezioneOperazioneIrrealizzabile {
        Noleggiamento nolleggiamentoEsistente = parcoVeicoli.get(codiceTelaio);
        if(nolleggiamentoEsistente != null){
            return parcoVeicoli.remove(codiceTelaio).getVeicolo();
        } else {
            throw new EccezioneOperazioneIrrealizzabile("Codice Telaio Inesistente!");
        }
    }
    
    // Metodo che Ricerca un Veicolo con un determinato numero di telaio
    public Veicolo searchVeicolo(String codiceTelaio) throws EccezioneOperazioneIrrealizzabile {
        Noleggiamento nolleggiamentoEsistente = parcoVeicoli.get(codiceTelaio);
        if(nolleggiamentoEsistente != null){
            return nolleggiamentoEsistente.getVeicolo();
        } else {
            throw new EccezioneOperazioneIrrealizzabile("Veicolo NON Trovato!");
        }
    }
    
    // Metodo che Restiuisce una Lista di Auto fornito un Modello e un Range di Costo del Noleggio
      
    // Metodo che Stampa tutte i Veicoli presenti nel Parco Veicoli
    public void printParcoVeicoli(){
        System.out.println("\nIl Parco Veicoli è: ");
        for(String codiceTelaio : parcoVeicoli.keySet()){
            System.out.println(parcoVeicoli.get(codiceTelaio));
        }
    }
    
    // Metodo che Noleggia o Restituisce un Veicolo 
    public void noleggiamentoVeicolo(String codiceTelaio, Noleggio noleggio) throws EccezioneOperazioneIrrealizzabile {
        Noleggiamento noleggiamento = parcoVeicoli.get(codiceTelaio);
        
        if(noleggiamento == null) {
            throw new EccezioneOperazioneIrrealizzabile("Veicolo NON Trovato!");
        }
        
        if(noleggiamento.getNoleggio() != null) {
            throw new EccezioneOperazioneIrrealizzabile("Veicolo già Noleggiato");
        } else {
            noleggiamento.setNoleggio(noleggio);
        }                    
    }
    
    // Metodo che Stampa tutte i Veicoli noleggiati attualmente
    public void printVeicoliNoleggiati(){
        System.out.println("\nI Veicoli Noleggiati attualmente sono: ");
        List<Veicolo> listaVeicoliNoleggiati = new ArrayList<Veicolo>();
        
        for (String codiceTelaio : parcoVeicoli.keySet()) {       
            Noleggiamento noleggiamento = parcoVeicoli.get(codiceTelaio);
            Veicolo veicolo = noleggiamento.getVeicolo();
            listaVeicoliNoleggiati.add(veicolo);      
        }
        
        listaVeicoliNoleggiati.forEach(System.out :: println);
         
    }
}
