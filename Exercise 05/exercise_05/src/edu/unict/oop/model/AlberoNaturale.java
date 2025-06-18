// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumarations.TipiProduttore;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class AlberoNaturale extends Albero {
    
    // ATTRIBUTI
    private int etaAlbero;
    private final boolean opzioneDaRestituire;
    
    // COSTRUTTORI
    public AlberoNaturale(int numeroIdentificativo, String marcaAlbero, TipiProduttore produttore, String mailCasaProduttrice, int etaAlbero, boolean opzioneDaRestituire) throws EccezioneOperazioneIrrealizzabile {
        super(numeroIdentificativo, marcaAlbero, produttore, mailCasaProduttrice);
        setEtaAlbero(etaAlbero);
        this.opzioneDaRestituire = opzioneDaRestituire;
    }
    
    // GETTER
    public int getEtaAlbero() {
        return etaAlbero;
    }

    public boolean isOpzioneDaRestituire() {
        return opzioneDaRestituire;
    }
    
    // SETTER
    public void setEtaAlbero(int etaAlbero) throws EccezioneOperazioneIrrealizzabile {
        if(etaAlbero == 0){
            throw new EccezioneOperazioneIrrealizzabile("Età NULLA non Ammessa!");
        } else if(etaAlbero < 0) { 
            throw new EccezioneOperazioneIrrealizzabile("Età NEGATIVA non Ammessa!");         
        }else{
            this.etaAlbero = etaAlbero; 
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "AlberoNaturale{" + "numeroIdentificativo=" + super.getNumeroIdentificativo() + ", marcaAlbero=" + super.getMarcaAlbero()
                    + ", produttore=" + super.getProduttore() + ", mailCasaProduttrice=" + super.getMailCasaProduttrice()
                    + ", prezzo=" + super.getPrezzo() + ", etaAlbero=" + etaAlbero + ", opzioneDaRestituire=" + opzioneDaRestituire + '}';
    }   
   
    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.50;
        if(opzioneDaRestituire == true){
            return detrazione;
        }
        
        double maggiorazione = 1.33;
        if(etaAlbero < 3 && opzioneDaRestituire == false){
            return maggiorazione;
        }
        
        double nessunCambiamento = 1;
        return nessunCambiamento;
   
    } 
}
