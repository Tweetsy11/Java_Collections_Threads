// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.ModelliMoto;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.UtentePatentato;
import edu.unict.oop.interfaces.VeicoloConPasseggeri;

public class Moto extends Veicolo implements VeicoloConPasseggeri, UtentePatentato {
    
    // ATTRIBUTI
    private final ModelliMoto modello;
    private final String targa;
    
    // COSTRUTTORI
    public Moto(String marca, ModelliMoto modello, String codiceTelaio, double costoBase, String targa) throws EccezioneOperazioneIrrealizzabile {
        super(marca, codiceTelaio, costoBase);
        this.modello = modello;
        this.targa = targa;
    }
    
    // GETTER
    public ModelliMoto getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }
    
    // toString
    @Override
    public String toString() {
        return "Moto{" + "marca=" + super.getMarca() + "modello=" + modello 
                    + ", codiceTelaio=" + super.getCodiceTelaio() + ", costoBase=" + super.getCostoBase() 
                    + ", targa=" + targa + '}';
    } 

    @Override
    public int CapienzaPasseggeri() {
        // DA IMPLEMENTARE
        return 0;
    }

    @Override
    public double CalcolatoreCosto() {   
        double costoBase = super.getCostoBase();   
        double costoTotaleAlGiorno = costoBase;
        return costoTotaleAlGiorno;
    }

    @Override
    public Patente getPatente() {
        // DA IMPLEMENTARE
        return null;  
    }
    
}
