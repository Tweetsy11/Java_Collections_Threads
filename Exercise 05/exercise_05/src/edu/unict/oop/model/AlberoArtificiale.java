// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumarations.TipiProduttore;

public class AlberoArtificiale extends Albero {

    // COSTRUTTORI
    public AlberoArtificiale(int numeroIdentificativo, String marcaAlbero, TipiProduttore produttore, String mailCasaProduttrice) {
        super(numeroIdentificativo, marcaAlbero, produttore, mailCasaProduttrice);
    }
    
    // toString
    @Override
    public String toString() {
        return "AlberoArtificiale{" + "numeroIdentificativo=" + super.getNumeroIdentificativo() + ", marcaAlbero=" + super.getMarcaAlbero()
                    + ", produttore=" + super.getProduttore() + ", mailCasaProduttrice=" + super.getMailCasaProduttrice() 
                    + ", prezzo=" + super.getPrezzo() + '}';
    }     

    @Override
    public double CalcolatorePrezzo() {
        double detrazione = 0.20;
        
        if(super.getProduttore().equals(super.getProduttore().ITALIANO)){
            return detrazione;
        }
        
        double nessunCambiamento = 1;
        return nessunCambiamento;
    }
    
}
