// PACKAGE
package edu.unict.oop.thread;

// IMPORT
import edu.unict.oop.enumarations.TipiProduttore;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.model.Acquisto;
import edu.unict.oop.model.AlberoArtificiale;
import edu.unict.oop.model.AlberoNaturale;
import edu.unict.oop.model.Archivio;
import java.util.Random;

public class Produttore implements Runnable {
    
    // ATTRIBUTI
    private final Archivio archivio;
    private final String name;
    
    // COSTRUTTORI
    public Produttore(Archivio archivio, String name) {
        this.archivio = archivio;
        this.name = name;
    }
    
    // GETTER
    public Archivio getArchivio() {
        return archivio;
    }

    public String getName() {
        return name;
    }
    
    // toString
    @Override
    public String toString() {
        return "Produttore{" + "archivio=" + archivio + ", name=" + name + '}';
    }

    // Generatore casuale Tipi Produttore Albero
    private TipiProduttore randomTipiProduttore() {
        int pick = new Random().nextInt(TipiProduttore.values().length);
        return TipiProduttore.values()[pick];
    }
    
    // Range di valori delle Marche degli Alberi
    private final String[] marcaAlberoArray = new String[] {"castagno", "pino", "mandorlo", "carrubbo", "ficus"};   
    
    
    // Metodo Utilizzato dal Thread Produttore (T1 e T2)
    @Override
    public void run() {
        
        int tempoMinimoSleep = 3000;
        int tempoMassimoSleep = 5000;
        
        int n = 0;     

        while(true){
            
            try {
                // tempo di elaborazione per simulare la generazione dei dati
                Thread.sleep((long)(tempoMinimoSleep + tempoMassimoSleep * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Thread Produttore " + name + " Interrotto!");                          
            } 
            
            Random random = new Random();  
                     
            // range di valori Opzione di Acquisto 
            int minOpzioneDiAcquisto = 1;
            int maxOpzioneDiAcquisto = 1;
            
            // generatore casuale Opzione di Acquisto     
            int opzioneDiAcquisto = random.nextInt(maxOpzioneDiAcquisto + minOpzioneDiAcquisto) + minOpzioneDiAcquisto;      
            
            // range di valori Eta Albero
            int minEtàAlbero = 1;
            int maxEtàAlbero = 110;  
                             
            // instanza degli acquisti degli alberi          
            if(opzioneDiAcquisto == 1){
                
                try {
                    n++;
                    int etaAlbero = random.nextInt(maxEtàAlbero + minEtàAlbero) + minEtàAlbero;
                    String marcaAlbero = marcaAlberoArray[(int)Math.round(Math.random())];
                    TipiProduttore produttore = randomTipiProduttore();
                    AlberoNaturale alberoNaturale = new AlberoNaturale(n, marcaAlbero, produttore, "produttore" + n + "gmail.com", etaAlbero, false);
                    Acquisto acquistoAlberoNaturale = new Acquisto(alberoNaturale); 
                    double prezzoFinale = acquistoAlberoNaturale.VariazionePrezzo();
                    acquistoAlberoNaturale.getAlbero().setPrezzo(prezzoFinale);
                    archivio.addAlbero(acquistoAlberoNaturale);
                    System.out.println("[THREAD PRODUTTORE " + name + "] Creato l'Acquisto: " + acquistoAlberoNaturale);
                    
                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }
            
            if(opzioneDiAcquisto == 2){  
                try {
                    int etaAlbero = random.nextInt(maxEtàAlbero + minEtàAlbero) + minEtàAlbero;
                    String marcaAlbero = marcaAlberoArray[(int)Math.round(Math.random())];
                    TipiProduttore produttore = randomTipiProduttore();
                    AlberoArtificiale alberoArtificiale = new AlberoArtificiale(n, marcaAlbero, produttore, "produttore" + n + "gmail.com");
                    Acquisto acquistoAlberoArtificale = new Acquisto(alberoArtificiale);
                    double prezzoFinale = acquistoAlberoArtificale.VariazionePrezzo();
                    alberoArtificiale.setPrezzo(prezzoFinale);
                    archivio.addAlbero(acquistoAlberoArtificale);
                    System.out.println("[THREAD PRODUTTORE " + name + "] Creato l'Acquisto: " + acquistoAlberoArtificale);

                } catch(EccezioneOperazioneIrrealizzabile ex){
                    System.err.println(ex.getMessage());
                    
                } catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }           
        }
    }
}
