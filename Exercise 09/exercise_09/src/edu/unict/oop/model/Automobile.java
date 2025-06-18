// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.ModelliAutomobile;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.CostoCauzione;
import edu.unict.oop.interfaces.UtentePatentato;
import edu.unict.oop.interfaces.VeicoloConPasseggeri;

public class Automobile extends Veicolo implements VeicoloConPasseggeri, UtentePatentato, CostoCauzione {
    
    // ATTRIBUTI
    private final ModelliAutomobile modello;
    private final String targa;
    
    // COSTRUTTORI
    public Automobile(String marca, ModelliAutomobile modello, String codiceTelaio, double costoBase, String targa) throws EccezioneOperazioneIrrealizzabile {
        super(marca, codiceTelaio, costoBase);
        this.modello = modello;
        this.targa = targa;
    }
    
    // GETTER
    public ModelliAutomobile getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }
    
    // toString
    @Override
    public String toString() {
        return "Automobile{" + "marca=" + super.getMarca() + "modello=" + modello 
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

    @Override
    public double CalcolatoreCauzione() {
        double costoBase = super.getCostoBase();
        double costoCauzione = costoBase * 7;
        return costoCauzione;
    }
           
}
