// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.enumerations.TipiSesso;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Archivio;
import edu.unict.oop.model.Cliente;
import edu.unict.oop.model.Gestante;
import java.util.Random;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String nome;
    
    // COSTRUTTORI
    public Produttore(Archivio arhivio, String nome) {
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
        return "Produttore{" + "arhivio=" + archivio + ", nome=" + nome + '}';
    }
     
    // Generatore casuale TipiSesso
    private TipiSesso randomTipiSesso() {
        int pick = new Random().nextInt(TipiSesso.values().length);
        return TipiSesso.values()[pick];
    }    
    
    // Range di valori Corsi per Clienti
    private final String[] corsoClienti = new String[] {"BASE", "PERFEZIONAMENTO"}; 

    // Range di valori Corsi per Gestanti
    private final String[] corsoGestanti = new String[] {"BASE", "PERFEZIONAMENTO", "CORSO_GESTANTI"};  

    
    // Metodo Utilizzato dal Thread Produttore T1
    @Override
    public void run() {
      
        int tempoMinimoSleep = 4000;
        int tempoMassimoSleep = 6000; 
       
        int n = 0;
       
        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Scrittore " + nome + " Interrotto!");                          
            }
            
            Random random = new Random();
            
            // range di valori Opzione di Cliente
            int minOpzioneDiCliente = 1;
            int maxOpzioneDiCliente = 2;   

	    // generatore casuale Opzione di Cliente     
            int opzioneDiCliente = random.nextInt(maxOpzioneDiCliente + minOpzioneDiCliente) + minOpzioneDiCliente;
            
            // range di valori Eta Gestante
            int minEtaGestante = 10;
            int maxEtaGestante = 50;
           
            // instanza dei clienti della piscina
            if(opzioneDiCliente == 1){
                
                try{
                    n++;
                    int etaCliente = (int)(Math.random());
                    TipiSesso sesso = randomTipiSesso();      
                    String corsoCliente = corsoClienti[(int)Math.round(Math.random())];
                    Cliente cliente = new Cliente("cognome" + n, etaCliente, sesso, corsoCliente);  
                    archivio.addCliente(cliente);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunto Cliente: " + cliente);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }
            }
           
            if(opzioneDiCliente == 2){
                
                try{
                    n++;
                    int etaGestante = random.nextInt(maxEtaGestante + minEtaGestante) + minEtaGestante;
                    String corsoGestante = corsoGestanti[(int)Math.round(Math.random())];
                    Gestante gestante = new Gestante("cognome" + n, etaGestante, TipiSesso.FEMMINA, corsoGestante);
                    archivio.addCliente(gestante);
                    System.out.println("[THREAD PRODUTTORE " + nome + "] Aggiunta Gestante: " + gestante);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                }
            }            
            
        }
    }
}
