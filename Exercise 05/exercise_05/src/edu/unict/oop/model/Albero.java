// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumarations.TipiProduttore;
import edu.unict.oop.interfaces.VariazionePrezzo;

public abstract class Albero implements VariazionePrezzo {
    
    // ATTRIBUTI
    private final int numeroIdentificativo;
    private final String marcaAlbero;
    private final TipiProduttore produttore;
    private final String mailCasaProduttrice;
    private double prezzo;
    
    // COSTRUTTORI
    public Albero(int numeroIdentificativo, String marcaAlbero, TipiProduttore produttore, String mailCasaProduttrice) {
        this.numeroIdentificativo = numeroIdentificativo;
        this.marcaAlbero = marcaAlbero;
        this.produttore = produttore;
        this.mailCasaProduttrice = mailCasaProduttrice;
        prezzo = 100;
    }
    
    // GETTER
    public int getNumeroIdentificativo() {
        return numeroIdentificativo;
    }

    public String getMarcaAlbero() {
        return marcaAlbero;
    }

    public TipiProduttore getProduttore() {
        return produttore;
    }

    public String getMailCasaProduttrice() {
        return mailCasaProduttrice;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    // SETTER
    public void setPrezzo(double prezzoBase) {
        this.prezzo = prezzo;
    }
    
    // toString
    @Override
    public String toString() {
        return "Albero{" + "numeroIdentificativo=" + numeroIdentificativo + ", marcaAlbero=" + marcaAlbero 
                    + ", produttore=" + produttore + ", mailCasaProduttrice=" + mailCasaProduttrice 
                    + ", prezzo=" + prezzo + '}';
    }
   
}
