// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiCorso;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {
    
    // ATTRIBUTI
    private final Map<String, Iscrizione> archivio;
    
    // COSTRUTTORI
    public Archivio() {
        this.archivio = new HashMap<String, Iscrizione>();
    }
    
    // GETTER
    public Map<String, Iscrizione> getArchivio() {
        return archivio;
    }
    
    // toString
    @Override
    public String toString() {
        return "Archivio{" + "archivio=" + archivio + '}';
    }
    
    // Metodo che Aggiunge un Cliente all'Archivio (se non presente)
    public void addCliente(ClienteAstratto cliente) throws EccezioneOperazioneIrrealizzabile {
        if(cliente == null){
            throw new EccezioneOperazioneIrrealizzabile("Cliente da Aggiungere NON SPECIFICATO!");
        }
        
        Iscrizione iscrizioneEsistente = archivio.get(cliente.getCodiceFiscale());
        if(iscrizioneEsistente == null){
            archivio.put(cliente.getCodiceFiscale(), new Iscrizione(cliente, null));
        } else { 
            throw new EccezioneOperazioneIrrealizzabile("Codice Fiscale già Usato!");
        }     
    }
    
    // Metodo che Rimuove un Cliente dall'Archivio (se presente)
    public ClienteAstratto removeCliente(String codiceFiscale) throws EccezioneOperazioneIrrealizzabile {
        Iscrizione iscrizioneEsistente = archivio.get(codiceFiscale);
        if (iscrizioneEsistente != null) {
            return archivio.remove(codiceFiscale).getCliente();
        } else {
            throw new EccezioneOperazioneIrrealizzabile("Codice Fiscale Inesistente!");
        }              
    }
    
    // Metodo che Ricerca un Cliente in base al Codice Fiscale
    public ClienteAstratto searchCliente(String codiceFiscale) throws EccezioneOperazioneIrrealizzabile {
        Iscrizione iscrizioneEsistente = archivio.get(codiceFiscale);
        if (iscrizioneEsistente == null) {
            throw new EccezioneOperazioneIrrealizzabile("Cliente NON Trovato!");
        }        
        return iscrizioneEsistente.getCliente();             
    }
      
    // Metodo di Stampa dell'Archivio 
    public void printArchivio(){
        System.out.println("\nL'Archivio dei Clienti della Piscina è: ");
        for (String codiceFiscale : archivio.keySet()) {
            System.out.println(archivio.get(codiceFiscale));
        }    
    }
    
    // Metodo di Iscrizione di un Cliente ad un Corso 
    public void iscrizioneCliente(String codiceFiscale, Corso corso) throws EccezioneOperazioneIrrealizzabile {       
        Iscrizione iscrizione = archivio.get(codiceFiscale);
        if (iscrizione == null) {
            throw new EccezioneOperazioneIrrealizzabile("Cliente NON Trovato");
        }
        
        if (iscrizione.getCorso() != null) {
            throw new EccezioneOperazioneIrrealizzabile("Cliente già Iscritto ad un Corso");
        }
        
        if(archivio.get(codiceFiscale).getCliente() instanceof Pulcino){
            if(corso.getCorso() == TipiCorso.CORSO_BASE || corso.getCorso() == TipiCorso.PALESTRA_GIOCHI){
                iscrizione.setCorso(corso);  
                double prezzoFinale = iscrizione.Sconto();
                iscrizione.getCorso().getCorso().setPrezzo(prezzoFinale);
            }else{
               throw new EccezioneOperazioneIrrealizzabile("Corso NON Disponibile per un Pulcino! ");
            }
        } else {
            iscrizione.setCorso(corso); 
            double prezzoFinale = iscrizione.Sconto();
            iscrizione.getCorso().getCorso().setPrezzo(prezzoFinale);
        }  
    }
    
    // Metodo per Ordinare per Età la Lista dei Pulcini dell'Archivio
    public List<Pulcino> PulciniOrdinati() {
        List<Pulcino> listaPulcini = new ArrayList<Pulcino>();

        for (String codiceFiscale : archivio.keySet()) {

            Iscrizione iscrizione = archivio.get(codiceFiscale);
            ClienteAstratto cliente = iscrizione.getCliente();

            if (cliente instanceof Pulcino) {
                listaPulcini.add((Pulcino) cliente);
            }
        }
        
        Collections.sort(listaPulcini);
        return listaPulcini;
    }
    
    // Metodo di Stampa della Lista dei Pulcini dell'Archivio
    public void printPulciniOrdinati(List<Pulcino> listaPulcini){
        System.out.println("\nLa Lista dei Pulcini presenti in Archivio ordinata per Età è: ");
        listaPulcini.forEach(System.out :: println);
    }   
}
